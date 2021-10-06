package com.api.SafetyNetAlerts.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.SafetyNetAlerts.model.Medications;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
//@Transactional
@Qualifier("medicastions")
@Repository
public interface MedicationRepository extends CrudRepository<Medications, Integer> {
	
}
