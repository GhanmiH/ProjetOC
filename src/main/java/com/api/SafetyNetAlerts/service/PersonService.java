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
		
			return personRepository.findAll();
		
	}

	/**
	 * add a person
	 * 
	 * @param person to add
	 * @return person added, or null object
	 * @throws Exception
	 */
	public Person addPerson(Person person) throws Exception {

		try {
			personRepository.save(person);
		} catch (Exception exception) {

			throw new Exception("The person could not be added:" + exception.getMessage());
		}
		return person;
	}

	/**
	 * Update a person if exist
	 *
	 * @param person to update
	 * @return person update, or null object, or person doesn't exist
	 */
	public Person updatePerson(Person person) {
		if (person != null) {
			Optional<Person> personOptional = this.getPersonByFirstNameAndLastName(person.getFirstName(),
					person.getLastName());

			if (personOptional.isPresent()) {
				Person personToUpdate = personOptional.get();

				personToUpdate.setAddress(person.getAddress());
				personToUpdate.setCity(person.getCity());
				personToUpdate.setEmail(person.getEmail());
				personToUpdate.setPhone(person.getPhone());
				personToUpdate.setZip(person.getZip());

				try {
					personRepository.save(personToUpdate);
					return personToUpdate;
				} catch (Exception exception) {
					logger.error("error while updating e person : " + exception.getMessage() + " StackTrace : "
							+ exception.getStackTrace());
					return null;
				}
			} else {
				logger.error("error while updating e person : Person doesn't exist");
				return null;
			}
		} else {
			logger.error("error while updating e person :  object null");
			return null;
		}
	}

	/**
	 * return list of exist person
	 *
	 * @return list of exist person
	 */
	public Optional<Person> getPersonByFirstNameAndLastName(String firstname, String lastname) {
		try {
			return personRepository.findByFirstNameAndLastNameAllIgnoreCase(firstname, lastname);
		} catch (Exception exception) {
			logger.error("Error while getting a person: " + exception.getMessage() + " Stack Trace + "
					+ exception.getStackTrace());
			return null;
		}
	}

	/**
	 * delete one person if exist
	 * 
	 * @param person to delete
	 * @return
	 */
	 public Person deletePerson(Person person) {
         personRepository.removeByFirstNameAndLastName(person.getFirstName(), person.getLastName());
		
			return person;
}

	 public Iterable<Person> getPersonFromAddress(String address) {
	        return personRepository.findPersonByAddress(address);
	    }

	}
