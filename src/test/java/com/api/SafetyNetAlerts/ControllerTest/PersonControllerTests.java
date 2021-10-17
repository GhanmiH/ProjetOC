package com.api.SafetyNetAlerts.ControllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.service.PersonService;
import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTests {
	@Autowired
    MockMvc mockMvc;
    @MockBean
    PersonService personservice;

    Person person;
    String personJson;
    List<Person> personList;

    @BeforeEach
    public void init() {
        person = new Person();
        person.setLastName("Boyd");
        person.setFirstName("John");
        person.setAddress("1509 Culver St");
        person.setCity("Culver");
        person.setPhone("841-874-6512");
        person.setEmail("jaboyd@email.com");
        person.setZip("97451");

        personJson = "{\n" +
                "        \"id\": 24,\n" +
                "        \"firstName\": \"John\",\n" +
                "        \"lastName\": \"Boyd\",\n" +
                "        \"address\": \"1509 Culver St\",\n" +
                "        \"city\": \"Culver\",\n" +
                "        \"zip\": \"97451\",\n" +
                "        \"phone\": \"841-874-6512\",\n" +
                "        \"email\": \"jaboyd@email.com\"\n" +
                "    }";
        personList = new ArrayList<>();
        personList.add(person);
    }
    
    @Test
    public void testGetAllPersons() throws Exception {
        when(personservice.getAllPersons()).thenReturn(personList);
        mockMvc.perform(get("/person"))
                .andExpect(status().isOk());
    }

  @Test
    public void testAddPerson () throws Exception {
        when(personservice.addPerson((Person) any(Person.class))).thenReturn(person);
        mockMvc.perform(post("/person")
        		 .contentType(MediaType.APPLICATION_JSON)
                .content(personJson))
                .andExpect(status().isOk());
    }
  @Test
  public void testUpdatePerson() throws Exception {
      when(personservice.updatePerson((Person) any(Person.class))).thenReturn(person);
      mockMvc.perform(put("/person")
              .contentType(MediaType.APPLICATION_JSON)
              .content(personJson))
              .andExpect(status().isOk());
  }
  
  @Test
  public void testDeletePersonFromLastNameAndFirstName () throws Exception {
      when(personservice.getPersonFromLastNameAndFirstName(anyString(), anyString()))
              .thenReturn(person);
      mockMvc.perform(delete("/person/test/test"))
              .andExpect(status().isOk());
  }
  
  @Test
  public void testToString()
  {
      ToStringVerifier.forClass(Person.class)
                    .withClassName(NameStyle.SIMPLE_NAME)
                    .verify();
  }
 
  
}