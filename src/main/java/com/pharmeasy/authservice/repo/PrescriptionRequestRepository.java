package com.pharmeasy.authservice.repo;

import com.pharmeasy.authservice.model.PrescriptionRequest;
import org.springframework.data.repository.CrudRepository;

public interface PrescriptionRequestRepository extends CrudRepository<PrescriptionRequest, Integer> {
    public PrescriptionRequest findByPrescriptionIDAndRequesterID(int prescriptionID, int requesterID);
}
