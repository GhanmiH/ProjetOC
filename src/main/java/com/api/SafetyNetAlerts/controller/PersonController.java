package com.api.SafetyNetAlerts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.service.PersonService;

@RestController
public class PersonController {

	private static final Logger logger = LogManager.getLogger(PersonController.class);

	@Autowired
	private PersonService personservice;

	@GetMapping("/person")
	public Iterable<Person> getAllPersons() {
		logger.info("requête GET sur le endpoint /persons");
		Iterable<Person> personIterable = personservice.getAllPersons();
		logger.info("req get endpoint persons done");
		return personIterable;
	}

	@PostMapping(value = "/person")
	public Person addPerson(@RequestBody Person person) throws Exception {
		logger.info("req Put endpoint 'person'");

		Person updatedPerson = personservice.addPerson(person);
		if (updatedPerson != null) {
			logger.info("req next Put endpoint 'person' ");
			return updatedPerson;
		} else {
			throw new Exception("person.added.error");
		}
	}

	@DeleteMapping("/person/{lastName}/{firstName}")
	public void deletePersonFromLastNameAndFirstName(@PathVariable("lastName") String lastName,
			@PathVariable("firstName") String firstName) {
		logger.info("requête DELETE sur le endpoint /person avec les paramètres lastName: " + lastName
				+ " et firstName: " + firstName);

		personservice.deletePersonFromLastNameAndFirstName(lastName, firstName);
	}

	@PutMapping("/person")
	public Person updatePerson(@RequestBody Person person) throws Exception {
		logger.info("req Put endpoint 'person'");

		Person updatedPerson = personservice.updatePerson(person);
		if (updatedPerson != null) {
			logger.info("req next Put endpoint 'person' ");
			return updatedPerson;
		} else {
			throw new Exception("person.update.error");
		}
	}

}
