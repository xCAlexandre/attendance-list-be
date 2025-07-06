package com.attendanceList.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceList.backend.dtos.AttendanceDTO;
import com.attendanceList.backend.dtos.AttendanceResponseDTO;
import com.attendanceList.backend.dtos.ErrorResponseDTO;
import com.attendanceList.backend.dtos.UserSummaryDTO;
import com.attendanceList.backend.model.Attendance;
import com.attendanceList.backend.model.user.User;
import com.attendanceList.backend.repositories.AttendanceRepository;
import com.attendanceList.backend.repositories.UserRepository;
import com.attendanceList.backend.services.AttendanceService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequestMapping("attendance")
@RestController
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity getAllAttendances() {
        List<Attendance> attendances = attendanceService.getAll();
         List<AttendanceResponseDTO> response = attendances.stream().map(attendance -> {
        User user = attendance.getUser();
        UserSummaryDTO userDTO = new UserSummaryDTO(user.getId(), user.getFullName(), user.getEmail());

        return new AttendanceResponseDTO(
            attendance.getId(),
            userDTO,
            attendance.isPresent(),
            attendance.getNotes(),
            attendance.getRegisteredAt()
        );
    }).toList();
        return ResponseEntity.ok(response);
    }

  @PostMapping("/")
    public ResponseEntity registerAttendance(@RequestBody AttendanceDTO data) {
    Optional<User> optionalUser = userRepository.findById(data.participantId());

    if (optionalUser.isEmpty()) {
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(new ErrorResponseDTO("User not found."));
    }

    User participant = optionalUser.get();
    Attendance attendance = new Attendance(participant, data.present(), data.notes());

    attendanceRepository.save(attendance);

    return ResponseEntity.ok().build();
}
    
    
}
