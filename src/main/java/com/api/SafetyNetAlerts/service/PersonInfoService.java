package com.api.SafetyNetAlerts.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.repository.MedicalRecordRepository;
import com.api.SafetyNetAlerts.repository.PersonRepository;

@Service
public class PersonInfoService {

	private static final Logger logger = LogManager.getLogger(PersonInfoService.class);

	private MedicalRecordRepository medicalRecordRepository;

	@Autowired
	private PersonRepository personRepository;

	
	 public List<String> getEmailsFromCity(String city) {
	        Iterable<Person> persons = personRepository.findAllByCity(city);
	        List<String> emails = new ArrayList<String>();
	        for (Person person : persons
	             ) {
	            if (!emails.contains(person.getEmail()))
	            emails.add(person.getEmail());
	        }
	        return emails;
	    }
}