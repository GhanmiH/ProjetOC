package com.api.SafetyNetAlerts.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.repository.PersonRepository;

@Service
public class PersonService {

	private static final Logger logger = LogManager.getLogger(PersonService.class);

	@Autowired
	private PersonRepository personRepository;

	/**
	 * Returns all of the existing people
	 *
	 */
	public Iterable<Person> getAllPersons() {
		try {
			return personRepository.findAll();
		} catch (Exception exception) {

			return null;
		}
	}

	/**
	 * add person
	 *
	 */
	public Person addPerson(Person person) {

		try {
			personRepository.save(person);
		} catch (Exception exception) {

			return null;
		}
		return person;
	}

}
