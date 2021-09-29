package com.api.SafetyNetAlerts.controller;


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


@RestController
public class FireStationController {

	private static final Logger logger = LogManager.getLogger(FireStationController.class);

	@Autowired
	private FireStationService firestationservice;

	/**
	 * Read - Get all fire stations
	 */

	@GetMapping("/firestation")
    public Iterable<FireStation> getAllStations(){
        logger.info("req get endpoint firestations  ");
        Iterable<FireStation> fireStationIterable =  firestationservice.getFireStations();
        logger.info("req get endpoint firestations done");
        return fireStationIterable;
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
		public FireStation  updateAddressForFireStation(@RequestBody FireStation firestation) throws Exception {
			logger.info("req Put endpoint 'firestation'");

			FireStation updatedFirestation = firestationservice.updateFireStation(firestation);
			if (updatedFirestation != null) {
				logger.info("req next Put endpoint 'firestation' ");
				return updatedFirestation;
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
