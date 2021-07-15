package com.api.SafetyNetAlerts.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.service.FireStationService;
import com.sun.istack.NotNull;

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

	@PostMapping(value = "/firestation")
	public FireStation addPerson(@RequestBody FireStation firestation) throws Exception {
		logger.info("req Put endpoint 'person'");

		FireStation updatedFirestation = firestationservice.addFirestation(firestation);
		if (updatedFirestation != null) {
			logger.info("req next Put endpoint 'firestation' ");
			return updatedFirestation;
		} else {
			throw new Exception("firestation.added.error");
		}
	}

	 @PutMapping("/firestation")
	    public void updateAddressForFireStation(
	            @NotNull @RequestBody final Map<String, String> mappingToUpdate,
	            final HttpServletResponse response) {

	        boolean isUpdated = firestationservice.updateAddressForFireStation(mappingToUpdate);

	        if (isUpdated) {
	            logger.info("OK 200 - UpdateFireStation PUT request " + "-  FireStation number : {}, Address : {}",
	                    mappingToUpdate.get("station"),
	                    mappingToUpdate.get("address"));
	            response.setStatus(Constants.MAJOR_VERSION);
	        } else {
	            response.setStatus(Constants.MINOR_VERSION);
	        }
	    }

	@DeleteMapping("/firestation")
	@Transactional
	public void deleteFireStation(@RequestBody FireStation firestation) {
		logger.info("Req Delete  endpoint 'firestation'");
		firestationservice.deleteFirestation(firestation);

	}
}
