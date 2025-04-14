package com.attendanceList.backend.dtos;

import com.attendanceList.backend.model.user.UserRole;

public record RegisterUserDTO(String email, String password, String fullName, UserRole role) {}
