package com.api.SafetyNetAlerts.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.SafetyNetAlerts.model.FireStation;




//This will be AUTO IMPLEMENTED by Spring into a Bean called firestationRepository
//CRUD refers Create, Read, Update, Delete
@Repository
public interface FireStationRepository extends CrudRepository<FireStation, Long> {

	Optional<FireStation> getFireStationByAddressAndStation(String address, int station);

	Optional<FireStation> findByAddressAllIgnoreCase(String address);

	void removeByAddressAndStation(String address, int station);

	Iterable<FireStation> findAllByStation(String station);


	

	
	
}
