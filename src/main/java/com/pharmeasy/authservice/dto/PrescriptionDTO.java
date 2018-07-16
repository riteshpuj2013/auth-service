package com.pharmeasy.authservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class PrescriptionDTO {
    private int prescriptionID;

    private int patientId;

    private String patientName;

    private String doctorName;

    private List<MedicineDosageDTO> medicines;
}
