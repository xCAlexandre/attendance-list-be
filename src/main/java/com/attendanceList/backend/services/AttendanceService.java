package com.attendanceList.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceList.backend.model.Attendance;
import com.attendanceList.backend.repositories.AttendanceRepository;

@Service
public class AttendanceService {
    @Autowired
    AttendanceRepository attendanceRepository;

    public List<Attendance> getAll(){
        List<Attendance> attendances = new ArrayList<>();

        attendanceRepository.findAll().forEach(attendances::add);

        return attendances;
    }
}
