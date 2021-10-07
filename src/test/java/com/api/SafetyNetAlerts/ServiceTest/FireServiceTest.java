package com.api.SafetyNetAlerts.ServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.api.SafetyNetAlerts.model.FireList;
import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.service.FireService;
import com.api.SafetyNetAlerts.service.FireStationService;
import com.api.SafetyNetAlerts.service.MedicalRecordService;
import com.api.SafetyNetAlerts.service.PersonService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@SpringBootTest
@AutoConfigureMockMvc
class FireServiceTest {
	@MockBean
    PersonService personService;
    @MockBean
    FireStationService firestationService;
    @MockBean
    MedicalRecordService medicalRecordService;

    @Autowired
    FireService fireService;
   /* @Test
    public void testGetPeopleWhenFire() {

        Person person = new Person();
        
    }*/
}
