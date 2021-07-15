package com.api.SafetyNetAlerts.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.SafetyNetAlerts.service.PhoneAlertService;

@RestController
public class PhoneAlertController {

	private static final Logger logger = LogManager.getLogger(PhoneAlertController.class);

	@Autowired
	PhoneAlertService phoneAlertService;

	@GetMapping("/phoneAlert/{firestationNumber}")
	public List<?> phoneAlert(@PathParam("firestation") String firestationNumber) {
		logger.info("requête sur le endpoint /phoneAlert{firestationNumber} avec le paramètre firestation: " + firestationNumber);
		return phoneAlertService.phoneAlert(firestationNumber);
	}
}