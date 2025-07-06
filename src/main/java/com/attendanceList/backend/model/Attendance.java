package com.attendanceList.backend.model;

import java.time.LocalDateTime;

import com.attendanceList.backend.model.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attendances", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"event_id", "participant_id"})
})
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "participant_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private boolean present;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(name = "registered_at", updatable = false)
    private LocalDateTime registeredAt;

    public Attendance(User participantId, boolean present, String notes){
        this.user = participantId;
        this.present = present;
        this.notes = notes;
        this.registeredAt = LocalDateTime.now();
    }
}
