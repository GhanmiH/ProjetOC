package com.safetynetsalerts.SaftyNetAlerts.ControllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.api.SafetyNetAlerts.controller.PersonController;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.service.PersonService;

@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest(controllers = PersonController.class)
@ActiveProfiles("test")
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    Person person;
    List<Person> personList;
    String personJson;


    @BeforeEach
    public void init() {
        person = new Person();
        person.setLastName("Cadigan");
        person.setFirstName("Eric");
        person.setAddress("951 LoneTree Rd");
        person.setCity("Culver");
        person.setPhone("841-874-7458");
        person.setEmail("gramps@email.com");
        person.setZip("97451");

        personList = new ArrayList<>();
        personList.add(person);

        personJson = "{\n" +
                "        \"id\": 23,\n" +
                "        \"firstName\": \"Eric\",\n" +
                "        \"lastName\": \"Cadigan\",\n" +
                "        \"address\": \"951 LoneTree Rd\",\n" +
                "        \"city\": \"Culver\",\n" +
                "        \"zip\": \"97451\",\n" +
                "        \"phone\": \"841-874-7458\",\n" +
                "        \"email\": \"gramps@email.com\"\n" +
                "    }";
    }

    @Test
    public void testAddPerson () throws Exception {
        when(personService.addPerson(any(Person.class))).thenReturn(person);
        mockMvc.perform(post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(personJson))
                .andExpect(status().isOk());
    }
}