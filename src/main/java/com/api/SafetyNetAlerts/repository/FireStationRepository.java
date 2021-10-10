package com.api.SafetyNetAlerts.repository;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.SafetyNetAlerts.model.FireStation;




//This will be AUTO IMPLEMENTED by Spring into a Bean called firestationRepository
//CRUD refers Create, Read, Update, Delete

@Transactional
@Repository
@Qualifier("firestation")
public interface FireStationRepository extends CrudRepository<FireStation, Integer> {

	Optional<FireStation> getFireStationByAddressAndStation(String address, int station);

	Optional<FireStation> findByAddressAllIgnoreCase(String address);

	Iterable<FireStation> findAllByStation(String station);

	Iterable<FireStation> findAllByAddress(String address);

	 void deleteByAddress(String address);

}
