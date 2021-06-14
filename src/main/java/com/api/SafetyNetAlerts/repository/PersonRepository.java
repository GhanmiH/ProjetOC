package com.api.SafetyNetAlerts.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.SafetyNetAlerts.model.Person;

public interface PersonRepository  extends CrudRepository<Person, Long> {

}
