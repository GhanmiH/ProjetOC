package com.api.SafetyNetAlerts.repository;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.SafetyNetAlerts.model.FirePeople;
import com.api.SafetyNetAlerts.model.FireStation;




//This will be AUTO IMPLEMENTED by Spring into a Bean called firestationRepository
//CRUD refers Create, Read, Update, Delete
@Qualifier("firestations")
@Repository
public interface FireStationRepository extends CrudRepository<FireStation, Integer> {

	Optional<FireStation> getFireStationByAddressAndStation(String address, int station);

	Optional<FireStation> findByAddressAllIgnoreCase(String address);

	void removeByAddressAndStation(String address, String string);

	Iterable<FireStation> findAllByStation(String station);

	Iterable<FirePeople> findAllByAddress(String address);
}
