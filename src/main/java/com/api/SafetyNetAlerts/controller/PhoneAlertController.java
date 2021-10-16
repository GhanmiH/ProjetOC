package com.api.SafetyNetAlerts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

import com.api.SafetyNetAlerts.service.PhoneAlertService;

@RestController
public class PhoneAlertController {

	private Logger logger = LogManager.getLogger(PhoneAlertController.class);

	private PhoneAlertService phoneAlertService;

	public PhoneAlertController(PhoneAlertService phoneAlertService) {

		this.phoneAlertService = phoneAlertService;
	}

	@GetMapping("/phoneAlert")
	public List<?> getphoneAlert(@PathParam("firestation") String firestation) {
		logger.info("requête GET sur le endpoint /phoneAlert avec le paramètre firestation: " + firestation);
		return phoneAlertService.getphoneAlert(firestation);
	}

}
