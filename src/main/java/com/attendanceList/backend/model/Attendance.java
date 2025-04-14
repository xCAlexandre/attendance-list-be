package com.attendanceList.backend.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.attendanceList.backend.model.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "attendances", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"event_id", "player_id"})
})
public class Attendance {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Events event;

    @ManyToOne(optional = false)
    @JoinColumn(name = "participant_id", nullable = false)
    private User player;

    @Column(nullable = false)
    private boolean present = true;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(name = "registered_at", updatable = false)
    private LocalDateTime registeredAt;
}
