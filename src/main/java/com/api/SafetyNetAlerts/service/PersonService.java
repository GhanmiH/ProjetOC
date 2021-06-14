package com.api.SafetyNetAlerts.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SafetyNetAlerts.repository.PersonRepository;


@Service
public class PersonService {
	
	
	private static final Logger logger = LogManager.getLogger(PersonService.class);

	@Autowired
    private PersonRepository personRepository;
	
}
