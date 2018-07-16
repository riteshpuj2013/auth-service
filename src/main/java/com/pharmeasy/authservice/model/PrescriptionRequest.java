package com.pharmeasy.authservice.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prescription_request")
@Builder
public class PrescriptionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "prescription_id")
    private int prescriptionID;

    @Column(name = "requester_id")
    private int requesterID;

    @Column(name = "is_access")
    private boolean isAccess;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
