package com.pharmeasy.authservice.repo;

import com.pharmeasy.authservice.model.Prescription;
import org.springframework.data.repository.CrudRepository;

public interface PrescriptionRepository extends CrudRepository<Prescription, Integer> {
}
