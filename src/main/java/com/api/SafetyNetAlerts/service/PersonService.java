package com.api.SafetyNetAlerts.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
	 * add a person
	 * 
	 *@param person to add
     * @return person added, or null object
	 */
	public Person addPerson(Person person) {

		try {
			personRepository.save(person);
		} catch (Exception exception) {

			return null;
		}
		return person;
	}
	
	/**
	 * delete person by his First and last name
	 * 
	 * 
	 *@param person to delete
     * @return person deleted, or null object
	 */
	public void deletePerson(Person person) {
		personRepository.removeByFirstNameAndLastName(person.getFirstName(), person.getLastName());

	}

	 /**
     * Update a person if exist
     *
     * @param person to update
     * @return person update, or null object or person doesn't exist
     */
    public Person updatePerson(Person person) {
        if (person != null) {
            Optional<Person> personOptional = this.getPersonByFirstNameAndLastName(person.getFirstName(), person.getLastName());

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
                    logger.error("error while updating e person");
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

	private Optional<Person> getPersonByFirstNameAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}


}
