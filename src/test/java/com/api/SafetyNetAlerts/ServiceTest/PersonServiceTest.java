package com.api.SafetyNetAlerts.ServiceTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.repository.PersonRepository;
import com.api.SafetyNetAlerts.service.MedicalRecordService;
import com.api.SafetyNetAlerts.service.PersonService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class PersonServiceTest {
	
	 @MockBean
	    PersonRepository personRepository;
	    @Autowired
	    PersonService personService ;
	    @MockBean
	    MedicalRecordService medicalRecordService;

	    @Test
	    public void AddPerson_ShouldUsePersonRepository() throws Exception {
	        Person person = new Person();
	        personService.addPerson(person);
	        verify(personRepository, times(1)).save(person);
	    }

	    @Test
	    public void getPersons_ShouldUsePersonRepository() {
	        /*List<Person> persons = new ArrayList<>();
	        Person p = new Person();
	        p.setPhone("phone");
	        persons.add(p);
	        when(personRepository.findAll()).thenReturn(persons);*/
	        personService.getAllPersons();
	        verify(personRepository, times(1)).findAll();
	    }

	    @Test
	    public void getPersonFromLastNameAndFirstName_ShouldUsePersonRepository() {
	        personService.getPersonFromLastNameAndFirstName(anyString(), anyString());
	        verify(personRepository, times(1)).findByLastNameAndFirstName(anyString(), anyString());
	    }

	    @Test
	    public void getPersonFromAddress_ShouldUsePersonRepository() {
	        personService.getPersonFromAddress(anyString());
	        verify(personRepository, times(1)).findPersonByAddress(anyString());
	    }
}
