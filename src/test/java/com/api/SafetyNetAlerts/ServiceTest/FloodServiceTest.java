package com.api.SafetyNetAlerts.ServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.api.SafetyNetAlerts.model.Allergies;
import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.model.Medications;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.service.FireStationService;
import com.api.SafetyNetAlerts.service.FloodService;
import com.api.SafetyNetAlerts.service.MedicalRecordService;
import com.api.SafetyNetAlerts.service.PersonService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FloodServiceTest {

	 @MockBean
	    PersonService personService;
	    @MockBean
	    FireStationService firestationService;
	    @MockBean
	    MedicalRecordService medicalRecordService;
	    @Autowired
	    FloodService floodService;
	    @Test
	    public void testGetPeopleWhenFloodFromStationNumber() {
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
	        medicalRecord.setAllergies(allergiesList);
	        medicalRecord.setMedications(medicationsList);
	        FireStation firestation = new FireStation();
	        firestation.setStation("1");
	        firestation.setAddress("a");
	        List firestations = new ArrayList<>();
	        firestations.add(firestation);
	        List<String> stationNumbers = new ArrayList<>();
	        stationNumbers.add("1");

	        when(firestationService.getFirestationsFromStationNumber(anyString())).thenReturn(firestations);
	        when(personService.getAge(anyString(), anyString())).thenReturn(10);
	        when(personService.getPersonFromAddress(anyString())).thenReturn(persons);
	        when(medicalRecordService.getMedicalRecordFromLastNameAndFirstName(anyString(), anyString())).thenReturn(medicalRecord);

	        List floodPeople = floodService.getPeopleWhenFloodFromStationNumber(stationNumbers);

	        verify(firestationService, times(1)).getFirestationsFromStationNumber(anyString());
	        verify(personService, times(1)).getAge(anyString(), anyString());
	        verify(personService, times(1)).getPersonFromAddress(anyString());
	        verify(medicalRecordService, times(2)).getMedicalRecordFromLastNameAndFirstName(anyString(), anyString());

	        assertEquals(1, floodPeople.size());
	    }


}
