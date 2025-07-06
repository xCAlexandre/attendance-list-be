package com.attendanceList.backend.dtos;

import java.time.LocalDateTime;

public record AttendanceResponseDTO(
        Integer id,
        UserSummaryDTO user,
        boolean isPresent,
        String notes,
        LocalDateTime registeredAt) {
}