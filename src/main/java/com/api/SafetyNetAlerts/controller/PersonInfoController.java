package com.api.SafetyNetAlerts.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.SafetyNetAlerts.model.PersonInfo;
import com.api.SafetyNetAlerts.repository.PersonRepository;
import com.api.SafetyNetAlerts.service.MedicalRecordService;
import com.api.SafetyNetAlerts.service.PersonInfoService;

@RestController
public class PersonInfoController {

	private static final Logger logger = LogManager.getLogger(PersonInfoController.class);

	@Autowired
	PersonInfoService personInfoService;

	@Autowired
	PersonRepository personRepositiry;
	
	@Autowired
    MedicalRecordService medicalRecordService;

	public PersonInfoController(PersonInfoService personInfoService) {
		this.personInfoService = personInfoService;

	}

	@GetMapping("/communityEmail")
	public List<?> getCommunityEmail(@PathParam("city") String city) {
		logger.info("requête GET sur le endpoint /communityEmail avec le paramètre city: " + city);
		return personInfoService.getEmailsFromCity(city);
	}
	
	@GetMapping("/personInfo")
    public PersonInfo getAllInfoPerson(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
        logger.info("requête GET sur le endpoint /personInfo avec les paramètres firstName: " + firstName + " et lastName: " + lastName);
        return personInfoService.getAllInfoPerson(firstName, lastName);
    }
	
}