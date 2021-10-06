package com.api.SafetyNetAlerts.ControllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.service.PersonService;


@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

   @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personservice;

    Person person;
    List<Person> personList;
    String personJson;

    @BeforeEach
    public void init() {
        person = new Person();
        person.setLastName("Ghanmi");
        person.setFirstName("Lilia");
        person.setAddress("37 avenue dubonnet");
        person.setCity("Paris");
        person.setPhone("147-458-5684");
        person.setEmail("liliaghanmi@email.com");
        person.setZip("92400");

        personJson = "{\n" +
                "        \"id\": 24,\n" +
                "        \"firstName\": \"Lilia\",\n" +
                "        \"lastName\": \"Ghanmi\",\n" +
                "        \"address\": \"37 avenue dubonnet\",\n" +
                "        \"city\": \"Paris\",\n" +
                "        \"zip\": \"92400\",\n" +
                "        \"phone\": \"841-874-7458\",\n" +
                "        \"email\": \"liliaghanmi@email.com\"\n" +
                "    }";
        personList = new ArrayList<>();
        personList.add(person);
    }

  /* @Test
    public void testAddPerson () throws Exception {
        when(personService.addPerson(any(Person.class))).thenReturn(person);
        mockMvc.perform(post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(personJson))
                .andExpect(status().isOk());
    }*/

    @Test
    public void testGetAllPersons() throws Exception {
        when(personservice.getAllPersons()).thenReturn(personList);
        mockMvc.perform(get("/person"))
                .andExpect(status().isOk());
    }

}