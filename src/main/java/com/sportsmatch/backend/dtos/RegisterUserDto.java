package com.sportsmatch.backend.dtos;

import com.sportsmatch.backend.model.user.UserRole;

public record RegisterUserDTO(String email, String password, String fullName, UserRole role) {}
