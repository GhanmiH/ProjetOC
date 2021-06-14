package com.api.SafetyNetAlerts.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.SafetyNetAlerts.model.FireStation;



//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
public interface FireStationRepository extends CrudRepository<FireStation, Long> {

	
}
