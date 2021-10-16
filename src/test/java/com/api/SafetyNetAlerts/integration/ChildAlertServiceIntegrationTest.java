package com.api.SafetyNetAlerts.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.api.SafetyNetAlerts.model.ChildAlertList;
import com.api.SafetyNetAlerts.service.ChildAlertService;
import com.api.SafetyNetAlerts.service.PersonService;

import static org.junit.Assert.*;

@SpringBootTest
@AutoConfigureMockMvc
class ChildAlertServiceIntegrationTest {

	 @Autowired
	    MockMvc mockMvc;

	@Autowired
    PersonService personService;
    @Autowired
    ChildAlertService childAlertService;

    @Test
    public void testGetChildFromAddress_whenMultipleChildren() {

        ChildAlertList childAlertList = childAlertService.getChildFromAddress("1509 Culver St");
        assertEquals(3, childAlertList.getOtherFamilyMembers().size());
        assertEquals(2, childAlertList.getChild().size());
    }
    @Test
    public void testGetChildFromAddress_whenZeroChildren() {
        ChildAlertList childAlertList = childAlertService.getChildFromAddress("29 15th St");
        assertEquals(1, childAlertList.getOtherFamilyMembers().size());
        assertEquals(0, childAlertList.getChild().size());
    }
}
