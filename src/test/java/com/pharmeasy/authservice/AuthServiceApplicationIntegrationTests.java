package com.pharmeasy.authservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = AuthServiceApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class AuthServiceApplicationIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenRequesterIDAndPrescriptionID_whenRequestPatientData_shouldReturnPrescriptionRequestDTO_Without_Prescription()
            throws Exception {
        int prescriptionID = 1;
        int requesterID = 1;
        mockMvc.perform(
                get("/api/prescription?requesterID={requesterID}&prescriptionID={prescriptionID}",
                        requesterID, prescriptionID)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("requestID").exists())
                .andExpect(jsonPath("prescriptionDTO").doesNotExist());
    }

    @Test
    public void givenRequesterIDAndPrescriptionID_whenUpdatePrescriptionAccess_shouldReturnNothing()
            throws Exception {
        int prescriptionID = 1;
        int requesterID = 1;
        mockMvc.perform(
                put("/api/prescription?requesterID={requesterID}&prescriptionID={prescriptionID}",
                        requesterID, prescriptionID)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void givenUserId_whenRequestPatientData_shouldReturnPrescriptionRequestDTO_With_Prescription() throws Exception {
        int prescriptionID = 1;
        int requesterID = 1;
        mockMvc.perform(
                get("/api/prescription?requesterID={requesterID}&prescriptionID={prescriptionID}"
                        , requesterID, prescriptionID)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("prescriptionDTO").exists());

    }

}
