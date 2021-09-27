package com.api.SafetyNetAlerts.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.SafetyNetAlerts.service.PersonInfoService;

@RestController
public class PersonInfoController {

	private static final Logger logger = LogManager.getLogger(PersonInfoController.class);

	private PersonInfoService personInfoService;

	public PersonInfoController(PersonInfoService personInfoService) {
		this.personInfoService = personInfoService;

	}

	@GetMapping("/communityEmail")
    public List<?> getCommunityEmail(@PathParam("city") String city) {
        logger.info("requête GET sur le endpoint /communityEmail avec le paramètre city: " + city);
        return personInfoService.getEmailsFromCity(city);
    }
}
