package com.api.SafetyNetAlerts.ServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.api.SafetyNetAlerts.model.Allergies;
import com.api.SafetyNetAlerts.model.FireList;
import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.model.Medications;
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
    
    @Test
    public void testGetPeopleWhenFire() {

        Person person = new Person();
        person.setLastName("Cadigan");
        person.setFirstName("Eric");
        person.setAddress("951 LoneTree Rd");
        person.setCity("Culver");
        person.setPhone("841-874-7458");
        person.setEmail("gramps@email.com");
        person.setZip("97451");
        List<Person> persons = new ArrayList<>();
        persons.add(person);
        MedicalRecord medicalRecord = new MedicalRecord();
        List<Allergies> allergiesList = new ArrayList<>();
        Allergies allergie1 = new Allergies();
        allergiesList.add(allergie1);

        List<Medications> medicationsList = new ArrayList<>();
        Medications medication1 = new Medications();
        
        medicationsList.add(medication1);
        
        medicalRecord = new MedicalRecord();
        medicalRecord.setAllergies(allergiesList);
        medicalRecord.setMedications(medicationsList);
        FireStation firestation = new FireStation();
        firestation.setStation("1");
        firestation.setAddress("a");
        List firestations = new ArrayList<>();
        firestations.add(firestation);

        when(personService.getPersonFromAddress(anyString())).thenReturn(persons);
        when(personService.getAge(anyString(), anyString())).thenReturn(10);
        when(medicalRecordService.getMedicalRecordFromLastNameAndFirstName(anyString(), anyString())).thenReturn(medicalRecord);
        when(firestationService.getFirestationFromAddress(anyString())).thenReturn(firestations);

        FireList fireList = fireService.getPeopleWhenFire(anyString());

        verify(personService, times(1)).getPersonFromAddress(anyString());
        verify(medicalRecordService, times(1)).getMedicalRecordFromLastNameAndFirstName(anyString(),anyString());
        verify(firestationService, times(1)).getFirestationFromAddress(anyString());

        assertEquals(10, fireList.getFirePeopleList().get(0).getAge());
    }
}
