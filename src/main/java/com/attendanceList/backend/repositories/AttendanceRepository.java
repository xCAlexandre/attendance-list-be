package com.attendanceList.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendanceList.backend.model.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{

}
