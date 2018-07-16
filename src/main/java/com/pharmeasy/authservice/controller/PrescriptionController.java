package com.pharmeasy.authservice.controller;

import com.pharmeasy.authservice.dto.PrescriptionRequestDTO;
import com.pharmeasy.authservice.exceptions.ResourceNotFoundException;
import com.pharmeasy.authservice.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    /**
     * GET API for requesting Prescription. This API returns Prescription data if access granted, else
     * registers request for the patient to approve
     * @param prescriptionID
     * @param requesterID
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/api/prescription")
    public ResponseEntity<PrescriptionRequestDTO> getPrescription(@RequestParam(value = "prescriptionID") int prescriptionID,
                                                                  @RequestParam(value = "requesterID") int requesterID) throws ResourceNotFoundException {
        PrescriptionRequestDTO prescriptionRequestDTO = prescriptionService.getPrescription(requesterID, prescriptionID);
        return ResponseEntity.ok(prescriptionRequestDTO);
    }

    /**
     * PUT API for patient to update the access of a prescription for a requester (doctor/pharmacist
     * @param prescriptionID
     * @param requesterID
     * @throws ResourceNotFoundException
     */
    @PutMapping("/api/prescription")
    public void updatePrescriptionAccess(@RequestParam(value = "prescriptionID") int prescriptionID,
                                         @RequestParam(value = "requesterID") int requesterID) throws ResourceNotFoundException {
        prescriptionService.updatePrescriptionAccess(requesterID, prescriptionID);
    }
}
