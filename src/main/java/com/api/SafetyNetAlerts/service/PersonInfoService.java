package com.api.SafetyNetAlerts.service;


import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.model.PersonInfo;
import com.api.SafetyNetAlerts.repository.PersonRepository;

@Service
public class PersonInfoService {

	private static final Logger logger = LogManager.getLogger(PersonInfoService.class);

	@Autowired
	public  PersonRepository personRepository;

	@Autowired
     MedicalRecordService medicalRecordService;
	@Autowired
	PersonService personservice;
	
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

	 public PersonInfo getAllInfoPerson(String firstName, String lastName) {
	        Person person = personservice.getPersonFromLastNameAndFirstName(lastName, firstName);
	        MedicalRecord medicalRecord = medicalRecordService.getMedicalRecordFromLastNameAndFirstName(lastName, firstName);

	        int age = personservice.getAge(lastName, firstName);
	        PersonInfo allInfoPerson = new PersonInfo();
	        allInfoPerson.setLastName(lastName);
	        allInfoPerson.setAge(age);
	        allInfoPerson.setAddress(person.getAddress());
	        allInfoPerson.setEmail(person.getEmail());
	        allInfoPerson.setAllergies(medicalRecord.getAllergies());
	        allInfoPerson.setMedications(medicalRecord.getMedications());

	        logger.info("réponse en retour à la requête GET sur le endpoint /personInfo avec les paramètres firstName: " + firstName + " et lastName: " + lastName);
	        return allInfoPerson;
	    }
	
}