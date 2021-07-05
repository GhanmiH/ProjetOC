package com.api.SafetyNetAlerts.controller;

import java.net.URI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.service.FireStationService;

@RestController
public class FireStationController {

	private static final Logger logger = LogManager.getLogger(FireStationController.class);

	@Autowired
	private FireStationService firestationservice;

	/**
	 * Read - Get all fire stations
	 */

	@GetMapping("/firestation")
	public Iterable<FireStation> getFireStations() {
		
		return firestationservice.getFireStations();
	}

	@PostMapping("/firestation")
	public ResponseEntity<Object> addFirestation(@RequestBody FireStation firestation) throws Exception {
		
		FireStation firestationAdded;
		try {
			firestationAdded = firestationservice.addFirestation(firestation);
		} catch (Exception e) {
			throw new Exception("The fire station could not be added:" + e.getMessage());
		}
		if (firestationAdded == null)

			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(firestationAdded.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	 @PutMapping("/firestation")
	    public FireStation updateFireStation(@RequestBody FireStation  firestation) throws Exception {
	        logger.info("req Put endpoint 'firestation'");

	        FireStation updatedFireStation = firestationservice.updateFireStation(firestation);
	        if (updatedFireStation != null) {
	            logger.info("req next Put endpoint 'firestation' ");
	            return updatedFireStation;
	        } else {
	            throw new Exception("firestation.update.error");
	        }
	    }
	 @DeleteMapping("/firestation")
		@Transactional
		public void deleteFireStation(@RequestBody FireStation firestation) {
			logger.info("Req Delete  endpoint 'firestation'");
			firestationservice.deleteFirestation(firestation);

		}
}
