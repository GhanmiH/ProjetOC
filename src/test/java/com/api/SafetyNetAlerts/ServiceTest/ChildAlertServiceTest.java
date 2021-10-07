package com.api.SafetyNetAlerts.ServiceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.api.SafetyNetAlerts.model.ChildAlertList;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.service.ChildAlertService;
import com.api.SafetyNetAlerts.service.PersonService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ChildAlertServiceTest {

	@MockBean
	PersonService personService;
	@Autowired
	ChildAlertService childAlertService;

	@Test
	public void testGetChildFromAddress() {
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

		when(personService.getPersonFromAddress(anyString())).thenReturn(persons);
		when(personService.getAge(anyString(), anyString())).thenReturn(10);

		ChildAlertList childAlertList = childAlertService.getChildFromAddress(anyString());

		verify(personService, times(1)).getPersonFromAddress(anyString());
		verify(personService, times(1)).getAge(anyString(), anyString());
		assertEquals(1, childAlertList.getChild().size());
	}

}