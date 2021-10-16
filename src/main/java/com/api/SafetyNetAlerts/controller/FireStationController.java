package com.api.SafetyNetAlerts.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public FireStation addFireStation(@RequestBody FireStation firestation) throws Exception {
		logger.info("req Post endpoint 'firestations'");

		FireStation updatedFirestation = firestationservice.addFirestation(firestation);
		if (updatedFirestation != null) {
			logger.info("req next Put endpoint 'firestation' ");
			return updatedFirestation;
		} else {
			throw new Exception("firestation.added.error");
		}
	}

	@PutMapping("/firestation/{address}")
    public void updateFirestation(@PathVariable("address") final String address, @RequestBody FireStation firestation) throws Exception {
        logger.info("requête PUT sur le endpoint /firestation avec le paramètre address: " + address);
        Iterable<FireStation> firestations = firestationservice.getFirestationFromAddress(address);
        for (FireStation firestation1 : firestations
        ) {
            String station = firestation.getStation();
            firestation1.setStation(station);

            firestationservice.addFirestation(firestation1);

        }
	}
	 @DeleteMapping("/firestation/{address}")
	    public void deleteFirestationByAddress(@PathVariable String address) {
	        logger.info("requête DELETE sur le endpoint /firestation/address avec le paramètre address: " + address);
	        firestationservice.deleteFirestationByAddress(address);
	    }
}
