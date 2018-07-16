package com.pharmeasy.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MedicineDosageDTO {
    private String medicineName;

    private int dosage;
}
