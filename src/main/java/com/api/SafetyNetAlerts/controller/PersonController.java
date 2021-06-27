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

	@GetMapping("/persons")
	public Iterable<Person> getAllPersons() {

		Iterable<Person> personIterable = personservice.getAllPersons();
		return personIterable;

	}

	@PostMapping("/person")
	public void addPerson(@RequestBody Person person) {

		personservice.addPerson(person);
	}
	
	@PutMapping("/person")
    public Person updatePerson(@RequestBody Person person) throws Exception {
        

        Person updatedPerson = personservice.updatePerson(person);
        if (updatedPerson != null) {
          
            return updatedPerson;
        } else {
            throw new Exception("person.update.error");
        }
    }
	@DeleteMapping("/person")
	public void deletePerson(@RequestBody Person person) {

		personservice.deletePerson(person);
	}
}
