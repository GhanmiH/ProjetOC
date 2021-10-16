package com.api.SafetyNetAlerts.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.api.SafetyNetAlerts.service.FireStationService;
import com.api.SafetyNetAlerts.service.PersonService;
import com.api.SafetyNetAlerts.service.PhoneAlertService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class PhoneAlertServiceIntegrationTest {

	@Autowired
	MockMvc mockMvc;
	@Autowired
	FireStationService firestationService;
	@Autowired
	PersonService personService;
	@Autowired
	PhoneAlertService phoneAlertService;

	@Test
	public void testPhoneAlert() {
		List<?> phoneAlertList = phoneAlertService.getphoneAlert("1");
		assertEquals(4, phoneAlertList.size());
	}

}
