package com.pharmeasy.authservice.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "doctor_id")
    private int doctorId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
