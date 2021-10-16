package com.api.SafetyNetAlerts.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.api.SafetyNetAlerts.model.PersonInfo;
import com.api.SafetyNetAlerts.service.MedicalRecordService;
import com.api.SafetyNetAlerts.service.PersonInfoService;
import com.api.SafetyNetAlerts.service.PersonService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class PersonInfoServiceIntegrationTest {
	 @Autowired
	  MockMvc mockMvc;
	@Autowired
    PersonService personService;
    @Autowired
    MedicalRecordService medicalRecordService;
    @Autowired
    PersonInfoService personInfoService;

    @Test
    public void testGetAllInfoPerson() {
        PersonInfo personInfo = personInfoService.getAllInfoPerson("Peter", "Duncan");
        assertEquals(21, personInfo.getAge());
    }
}
