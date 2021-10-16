package com.api.SafetyNetAlerts.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.repository.PersonRepository;
import com.api.SafetyNetAlerts.service.PersonInfoService;
import com.api.SafetyNetAlerts.service.PersonService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class PersonServiceIntegrationTest {

	@Autowired
	MockMvc mockMvc;
	@Autowired
	PersonRepository personRepository;
	@Autowired
	PersonInfoService personInfoService;
	@Autowired
	PersonService personService;

	@Test
	public void testGetEmailsFromCity() {
		List<?> emails = personInfoService.getEmailsFromCity("Culver");
		assertEquals(15, emails.size());
	}
	
	 @Test
	    public void testGetPersonFromLastNameAndFirstName() {
	        Person person = personService.getPersonFromLastNameAndFirstName("Boyd", "John");
	        assertEquals("jaboyd@email.com", person.getEmail());
	    }

}
