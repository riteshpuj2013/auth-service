package com.pharmeasy.authservice.service;

import com.pharmeasy.authservice.dto.PrescriptionRequestDTO;
import com.pharmeasy.authservice.exceptions.ResourceNotFoundException;

public interface PrescriptionService {
    PrescriptionRequestDTO registerPrescriptionRequest(int requesterID, int prescriptionID);

    PrescriptionRequestDTO checkPrescriptionRequest(int requesterID, int prescriptionID);

    PrescriptionRequestDTO getPrescription(int requesterID, int prescriptionID) throws ResourceNotFoundException;

    void updatePrescriptionAccess(int requesterID, int prescriptionID) throws ResourceNotFoundException;
}
