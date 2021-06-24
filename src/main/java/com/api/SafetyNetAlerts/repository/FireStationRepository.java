package com.api.SafetyNetAlerts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.SafetyNetAlerts.model.FireStation;



//This will be AUTO IMPLEMENTED by Spring into a Bean called firestationRepository
//CRUD refers Create, Read, Update, Delete
@Repository
public interface FireStationRepository extends CrudRepository<FireStation, Long> {

	
	
}
