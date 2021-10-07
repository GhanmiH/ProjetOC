package com.api.SafetyNetAlerts.ServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.repository.MedicalRecordRepository;
import com.api.SafetyNetAlerts.service.MedicalRecordService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@SpringBootTest
class MedicalRecordServiceTest {

	@MockBean
    MedicalRecordRepository medicalRecordRepository;
    @Autowired
    MedicalRecordService medicalRecordService;


    @Test
    public void getMedicalRecordFromLastNameAndFirstName_ShouldUseMedicalRecordRepository() {
        medicalRecordService.getMedicalRecordFromLastNameAndFirstName(anyString(), anyString());
        verify(medicalRecordRepository, times(1)).findMedicalRecordByLastNameAndFirstName(anyString(), anyString());
    }

}
