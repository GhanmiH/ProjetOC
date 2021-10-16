package com.api.SafetyNetAlerts.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.repository.FireStationRepository;



@Service
public class FireStationService {

	private static final Logger logger = LogManager.getLogger(FireStationService.class);

	@Autowired
	private FireStationRepository firestationrepository;

	
	public Iterable<FireStation> getFireStations() {
		return firestationrepository.findAll();

	}

	/**
	 * add a fire station
	 * 
	 * @param firestation to add
	 * @return firestation added, or null object
	 * @throws Exception
	 */
	public FireStation addFirestation(FireStation firestation) {
        return firestationrepository.save(firestation);
    }
	public Iterable<FireStation> getFirestationsFromStationNumber(String station) {
        return firestationrepository.findAllByStation(station);
    }

	public Iterable<FireStation> getFirestationFromAddress(String address) {
		return firestationrepository.findAllByAddress(address);
	}

	 public void deleteFirestationByAddress(String address) {
		 firestationrepository.deleteByAddress(address);
	    }

}