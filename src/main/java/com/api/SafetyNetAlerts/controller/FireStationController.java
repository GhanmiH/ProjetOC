package com.api.SafetyNetAlerts.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.SafetyNetAlerts.model.FireStation;
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
	 @GetMapping("/firestation/{id}")
		public FireStation  getFireStation(@PathVariable("id") final Long id) {
			Optional<FireStation> firestation = firestationservice. getFireStation(id);
			if(firestation.isPresent()) {
				return firestation.get();
			} else {
				return null;
			}
		}	
}
