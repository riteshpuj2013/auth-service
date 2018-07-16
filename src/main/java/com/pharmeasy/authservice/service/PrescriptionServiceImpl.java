package com.pharmeasy.authservice.service;

import com.pharmeasy.authservice.dto.PrescriptionDTO;
import com.pharmeasy.authservice.dto.PrescriptionRequestDTO;
import com.pharmeasy.authservice.exceptions.ResourceNotFoundException;
import com.pharmeasy.authservice.mapper.PrescriptionDTOMapper;
import com.pharmeasy.authservice.model.Prescription;
import com.pharmeasy.authservice.model.PrescriptionRequest;
import com.pharmeasy.authservice.repo.PrescriptionRepository;
import com.pharmeasy.authservice.repo.PrescriptionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRequestRepository prescriptionRequestRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public PrescriptionRequestDTO registerPrescriptionRequest(int requesterID, int prescriptionID) {

        PrescriptionRequest prescriptionRequest = PrescriptionRequest.builder()
                .prescriptionID(prescriptionID)
                .requesterID(requesterID)
                .build();
        PrescriptionRequest prescriptionRequestFromDB = prescriptionRequestRepository.save(prescriptionRequest);
        System.out.println("prescriptionRequestFromDB " + prescriptionRequestFromDB);
        return PrescriptionRequestDTO.builder()
                .requestID(prescriptionRequestFromDB.getId())
                .isAccess(prescriptionRequestFromDB.isAccess())
                .build();
    }

    @Override
    public PrescriptionRequestDTO checkPrescriptionRequest(int requesterID, int prescriptionID) {
        PrescriptionRequest prescriptionRequest =
                prescriptionRequestRepository.findByPrescriptionIDAndRequesterID(requesterID, prescriptionID);
        PrescriptionRequestDTO prescriptionRequestDTO;
        System.out.println("prescriptionRequest " + prescriptionRequest);
        if (prescriptionRequest == null) {
            prescriptionRequestDTO = registerPrescriptionRequest(requesterID, prescriptionID);
        } else {
            prescriptionRequestDTO = PrescriptionRequestDTO.builder()
                    .requestID(prescriptionRequest.getId())
                    .isAccess(prescriptionRequest.isAccess())
                    .build();
        }
        System.out.println("prescriptionRequestDTO " + prescriptionRequestDTO);
        return prescriptionRequestDTO;
    }

    @Override
    public PrescriptionRequestDTO getPrescription(int requesterID, int prescriptionID) throws ResourceNotFoundException {
        if(!prescriptionRepository.existsById(prescriptionID)){
            throw new ResourceNotFoundException(Prescription.class, "id", String.valueOf(prescriptionID));
        }

        PrescriptionRequestDTO prescriptionRequestDTO = checkPrescriptionRequest(requesterID, prescriptionID);
        if (prescriptionRequestDTO.isAccess()) {
            String sql = "select pr.id as 'prescripion_id', pa.id as 'patient_id', pa.name as 'patient_name',preq.name as 'doctor_name',m.name as 'medicine_name'" +
                    ", pmm.dosage_per_day from prescription pr, patient pa, \n" +
                    "prescription_requestors preq, prescription_medicine_mapping pmm, medicines m where pr.patient_id=pa.id \n" +
                    "and preq.id=pr.doctor_id and pr.id=pmm.prescription_id and m.id=pmm.medicine_id and pr.id=:prescriptionID;";
            Map<String, Object> map = new HashMap<>();
            map.put("prescriptionID", prescriptionID);
            PrescriptionDTO prescriptionDTO = jdbcTemplate.query(sql, map, new PrescriptionDTOMapper());
            prescriptionRequestDTO.setPrescriptionDTO(prescriptionDTO);
            prescriptionRequestDTO.setAccess(true);
        }
        return prescriptionRequestDTO;
    }

    @Override
    public void updatePrescriptionAccess(int requesterID, int prescriptionID) throws ResourceNotFoundException {
        if(!prescriptionRepository.existsById(prescriptionID)){
            throw new ResourceNotFoundException(Prescription.class, "id", String.valueOf(prescriptionID));
        }
        PrescriptionRequest request = prescriptionRequestRepository.findByPrescriptionIDAndRequesterID(prescriptionID, requesterID);
        request.setAccess(true);
        prescriptionRequestRepository.save(request);
    }


}