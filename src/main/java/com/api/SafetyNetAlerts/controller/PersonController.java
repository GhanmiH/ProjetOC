package com.api.SafetyNetAlerts.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.service.PersonService;


@RestController
public class PersonController {

	private static final Logger logger = LogManager.getLogger(PersonController.class);
	
	@Autowired
    private PersonService personservice;
	
	@GetMapping("/persons")
    public Iterable<Person> getAllPersons() {
		
        Iterable<Person> personIterable = personservice.getAllPersons();
        return personIterable;
        
    }
	
}
