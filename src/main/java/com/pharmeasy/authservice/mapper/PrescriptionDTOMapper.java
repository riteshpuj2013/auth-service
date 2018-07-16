package com.pharmeasy.authservice.mapper;

import com.pharmeasy.authservice.dto.MedicineDosageDTO;
import com.pharmeasy.authservice.dto.PrescriptionDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionDTOMapper implements ResultSetExtractor<PrescriptionDTO> {

    @Override
    public PrescriptionDTO extractData(ResultSet rs) throws SQLException, DataAccessException {
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        if (rs.isBeforeFirst()) {
            rs.next();
            prescriptionDTO.setDoctorName(rs.getString("doctor_name"));
            prescriptionDTO.setPatientId(rs.getInt("patient_id"));
            prescriptionDTO.setPatientName(rs.getString("patient_name"));
            prescriptionDTO.setPrescriptionID(rs.getInt("prescripion_id"));
            List<MedicineDosageDTO> medicineDosageDTOList = new ArrayList<>();
            medicineDosageDTOList.add(new MedicineDosageDTO(rs.getString("medicine_name")
                    , rs.getInt("dosage_per_day")));
            while (rs.next()) {
                medicineDosageDTOList.add(new MedicineDosageDTO(rs.getString("medicine_name")
                        , rs.getInt("dosage_per_day")));
            }
            prescriptionDTO.setMedicines(medicineDosageDTOList);
            System.out.println("prescriptionDTO "+prescriptionDTO);
        }
        return prescriptionDTO;
    }
}
