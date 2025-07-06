package com.attendanceList.backend.dtos;


public record AttendanceDTO(Integer participantId, boolean present, String notes){
}
