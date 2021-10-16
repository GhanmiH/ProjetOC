package com.api.SafetyNetAlerts.ServiceTest;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.model.FireStationPeopleList;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.service.FireStationPeopleService;
import com.api.SafetyNetAlerts.service.FireStationService;
import com.api.SafetyNetAlerts.service.PersonService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
 
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class FireStationPeopleServiceTest {

	 @MockBean
	    PersonService personService;
	    @MockBean
	    FireStationService firestationService;
	    @Autowired
	    FireStationPeopleService firestationPeopleService;

	    @Test
	    public void testGetPeopleFromFirestationNumber() {
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
	         FireStation firestation = new FireStation();
	         firestation.setStation("1");
	         firestation.setAddress("a");
	         List firestations = new ArrayList<>();
	         firestations.add(firestation);


	         when(firestationService.getFirestationsFromStationNumber(anyString())).thenReturn(firestations);
	         when(personService.getPersonFromAddress(anyString())).thenReturn(persons);
	         when(personService.getAge(anyString(), anyString())).thenReturn(10);

	         FireStationPeopleList firestationPeopleList = firestationPeopleService.getPeopleFromFirestationNumber(anyString());

	         verify(firestationService, times(1)).getFirestationsFromStationNumber(anyString());
	         verify(personService, times(1)).getPersonFromAddress(anyString());
	         verify(personService, times(1)).getAge(anyString(), anyString());
	         assertEquals(1, firestationPeopleList.getChild());
	         assertEquals(0, firestationPeopleList.getAdult());	
	    	
	    	
	    }
}
