package com.api.SafetyNetAlerts.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.repository.MedicalRecordRepository;
import com.api.SafetyNetAlerts.service.MedicalRecordService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@AutoConfigureMockMvc
class MedicalRecordServiceIntegrationTest {

	@Autowired
    MedicalRecordService medicalRecordService;
    @Autowired
    MedicalRecordRepository medicalRecordRepository;

    @Test
    public void testGetMedicalRecordFromLastNameAndFirstName(){
        MedicalRecord medicalRecord = medicalRecordService.getMedicalRecordFromLastNameAndFirstName("Boyd", "John");
        assertEquals(LocalDate.parse("03/06/1984",DateTimeFormatter.ofPattern("MM/dd/yyyy")), medicalRecord.getBirthdate ());
    }

}
