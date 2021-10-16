package com.api.SafetyNetAlerts.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.api.SafetyNetAlerts.model.FireList;
import com.api.SafetyNetAlerts.service.FireService;
import com.api.SafetyNetAlerts.service.FireStationService;
import com.api.SafetyNetAlerts.service.MedicalRecordService;
import com.api.SafetyNetAlerts.service.PersonService;

import static org.junit.Assert.*;

@SpringBootTest
@AutoConfigureMockMvc
class FireServiceIntegrationTest {

	 @Autowired
	    MockMvc mockMvc;
	@Autowired
    PersonService personService;
    @Autowired
    FireStationService firestationService;
    @Autowired
    MedicalRecordService medicalRecordService;
    @Autowired
    FireService fireService;

    @Test
    public void testGetPeopleWhenFire_whenOnePerson() {
        FireList fireList = fireService.getPeopleWhenFire("29 15th St");
        assertEquals(1, fireList.getFirePeopleList().size());
    }

    @Test
    public void testGetPeopleWhenFire_whenMultiplePerson() {
        FireList fireList = fireService.getPeopleWhenFire("1509 Culver St");
        assertEquals(5, fireList.getFirePeopleList().size());
    }
}
