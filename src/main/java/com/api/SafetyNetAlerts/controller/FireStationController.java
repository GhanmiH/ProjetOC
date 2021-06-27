package com.api.SafetyNetAlerts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
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
}
