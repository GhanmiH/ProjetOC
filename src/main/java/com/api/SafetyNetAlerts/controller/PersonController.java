package com.api.SafetyNetAlerts.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.api.SafetyNetAlerts.repository.PersonRepository;



@Controller
public class PersonController {

	private static final Logger logger = LogManager.getLogger(PersonController.class);
	
	@Autowired
    private PersonRepository personrepository;
	
}
