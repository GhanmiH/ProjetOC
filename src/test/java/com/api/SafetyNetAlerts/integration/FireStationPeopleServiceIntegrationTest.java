package com.api.SafetyNetAlerts.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.api.SafetyNetAlerts.model.FireStationPeopleList;
import com.api.SafetyNetAlerts.service.FireStationPeopleService;
import com.api.SafetyNetAlerts.service.FireStationService;
import com.api.SafetyNetAlerts.service.PersonService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class FireStationPeopleServiceIntegrationTest {

	 @Autowired
	    MockMvc mockMvc;
	 @Autowired
	    FireStationService firestationService;
	    @Autowired
	    PersonService personService;
	    @Autowired
	    FireStationPeopleService firestationPeopleService;

	    @Test
	    public void testGetPeopleFromFirestationNumber() {
	        FireStationPeopleList firestationPeopleList = firestationPeopleService.getPeopleFromFirestationNumber("1");
	        assertEquals(5, firestationPeopleList.getAdult());
	        assertEquals(1, firestationPeopleList.getChild());
	    }

}
