package com.pharmeasy.authservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class PrescriptionRequestDTO {
    private int requestID;

    private boolean isAccess = false;

    private PrescriptionDTO prescriptionDTO;
}
