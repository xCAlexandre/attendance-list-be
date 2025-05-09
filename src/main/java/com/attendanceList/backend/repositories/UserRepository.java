package com.attendanceList.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.attendanceList.backend.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    UserDetails findByEmail(String email);
}
