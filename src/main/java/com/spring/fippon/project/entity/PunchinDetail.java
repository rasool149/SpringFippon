package com.spring.fippon.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "punch_in_details")
@NoArgsConstructor
@AllArgsConstructor
public class PunchinDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "punch_in_time", nullable = false)
    private LocalDateTime punchInTime;

    @Column(name = "punch_out_time")
    private LocalDateTime punchOutTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDetail user;

    @Column(name = "distance_traveled")
    private Double distanceTraveled;

    // New fields to store latitude and longitude for punch in
    @Column(name = "punch_in_latitude")
    private Double punchInLatitude;

    @Column(name = "punch_in_longitude")
    private Double punchInLongitude;

    // New fields to store latitude and longitude for punch out
    @Column(name = "punch_out_latitude")
    private Double punchOutLatitude;

    @Column(name = "punch_out_longitude")
    private Double punchOutLongitude;
}
