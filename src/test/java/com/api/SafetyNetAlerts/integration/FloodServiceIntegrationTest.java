package com.api.SafetyNetAlerts.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.api.SafetyNetAlerts.service.FireStationService;
import com.api.SafetyNetAlerts.service.FloodService;
import com.api.SafetyNetAlerts.service.MedicalRecordService;
import com.api.SafetyNetAlerts.service.PersonService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class FloodServiceIntegrationTest {

	 @Autowired
	 MockMvc mockMvc;
	@Autowired
    FireStationService firestationService;
    @Autowired
    PersonService personService;
    @Autowired
    MedicalRecordService medicalRecordService;
    @Autowired
    FloodService floodService;

    @Test
    public void testGetPeopleWhenFloodFromStationNumber_whenOneStationNumber() {
        List<?> floodPeopleList = floodService.getPeopleWhenFloodFromStationNumber(Collections.singletonList("1"));
        assertEquals(3, floodPeopleList.size());
    }

    @Test
    public void testGetPeopleWhenFloodFromStationNumber_whenMultipleStationNumber() {
        List<String> stationNumbers = new ArrayList<String>();
        stationNumbers.add("1");
        stationNumbers.add("2");
        System.out.println(stationNumbers);
        List<?> floodPeopleList = floodService.getPeopleWhenFloodFromStationNumber(stationNumbers);
        assertEquals(6, floodPeopleList.size());
    }

}
