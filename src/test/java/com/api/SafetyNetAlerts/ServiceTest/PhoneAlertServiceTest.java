package com.api.SafetyNetAlerts.ServiceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.service.FireStationService;
import com.api.SafetyNetAlerts.service.PersonService;
import com.api.SafetyNetAlerts.service.PhoneAlertService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PhoneAlertServiceTest {

	 @MockBean
	    FireStationService firestationService;
	    @MockBean
	    PersonService personService;
	    @Autowired
	    PhoneAlertService phoneAlertService;

	    List<FireStation> firestations = new ArrayList<>();
	    FireStation f1 = new FireStation();
	    FireStation f2 = new FireStation();

	    List<Person> persons = new ArrayList<>();
	    Person p1 = new Person();
	    Person p2 = new Person();

	    @BeforeEach
	    public void init() {

	    f1.setStation("1");
	    f1.setAddress("rue de Paris");
	    f2.setStation("2");
	    f2.setAddress("rue de Paris");
	    firestations.add(f1);
	    firestations.add(f2);

	    p1.setPhone("123");
	    p1.setAddress("rue de Paris");
	    p2.setPhone("123");
	    p2.setAddress("rue de Lille");
	    persons.add(p1);
	    persons.add(p2);

	    }

	    @Test
	    public void testPhoneAlert() {
	        when(firestationService.getFirestationsFromStationNumber(anyString())).thenReturn(firestations);
	        when(personService.getPersonFromAddress(anyString())).thenReturn(persons);

	        List<String> result = phoneAlertService.getphoneAlert(anyString());

	        verify(firestationService, times(1)).getFirestationsFromStationNumber(anyString());
	        verify(personService, times(2)).getPersonFromAddress(anyString());

	        List<String> expectedPhoneList = new ArrayList<>();
	        expectedPhoneList.add("123");
	        assertEquals(expectedPhoneList, result);
	    }
}
