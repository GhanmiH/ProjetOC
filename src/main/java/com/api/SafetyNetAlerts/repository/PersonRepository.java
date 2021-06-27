package com.api.SafetyNetAlerts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.SafetyNetAlerts.model.Person;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	void removeByFirstNameAndLastName(String firstName, String lastName);

}
