package com.api.SafetyNetAlerts.controller;

import java.net.URI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping(value = "/person")
	public ResponseEntity<Person> addPerson(@RequestBody Person person) throws Exception {

		Person personAdded;
		try {
			personAdded = personservice.addPerson(person);
		} catch (Exception e) {
			throw new Exception("The person could not be added:" + e.getMessage());
		}

		if (personAdded == null)

			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(personAdded.getid()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/person")
	@Transactional
	public void deletePerson(@RequestBody Person person) {
		logger.info("Req Delete  endpoint 'person'");
		personservice.deletePerson(person);

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
