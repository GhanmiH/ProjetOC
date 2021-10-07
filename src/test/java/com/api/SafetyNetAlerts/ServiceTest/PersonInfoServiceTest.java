package com.api.SafetyNetAlerts.ServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.model.PersonInfo;
import com.api.SafetyNetAlerts.service.MedicalRecordService;
import com.api.SafetyNetAlerts.service.PersonInfoService;
import com.api.SafetyNetAlerts.service.PersonService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/*
@SpringBootTest
class PersonInfoServiceTest {

	@MockBean
    PersonService personService;
    @MockBean
    MedicalRecordService medicalRecordService;
    @Autowired
    PersonInfoService personInfoService;



    @Test
    public void testGetAllInfoPerson() {
        Person person = new Person();
        person.setLastName("Cadigan");
        person.setFirstName("Eric");
        person.setAddress("951 LoneTree Rd");
        person.setCity("Culver");
        person.setPhone("841-874-7458");
        person.setEmail("gramps@email.com");
        person.setZip("97451");
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setAllergies(Collections.singletonList("aspirine"));
        medicalRecord.setMedications(Collections.singletonList("aspirine"));


        when(personService.getPersonFromLastNameAndFirstName(anyString(), anyString()))
                .thenReturn(person);
        when(medicalRecordService.getMedicalRecordFromLastNameAndFirstName(anyString(), anyString()))
                .thenReturn(medicalRecord);

        PersonInfo personInfo = personInfoService.getAllInfoPerson(person.getFirstName(), person.getLastName());

        verify(personService, times(1)).getPersonFromLastNameAndFirstName(anyString(), anyString());
        verify(medicalRecordService, times(1)).getMedicalRecordFromLastNameAndFirstName(anyString(), anyString());

        assertEquals(medicalRecord.getAllergies(), personInfo.getAllergies());
        assertEquals(person.getLastName(), personInfo.getLastName());

    }

}*/
