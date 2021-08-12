package com.api.SafetyNetAlerts.controller;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.SafetyNetAlerts.model.FireStationPeopleList;
import com.api.SafetyNetAlerts.service.FireStationPeopleService;
 

@RestController
public class FireStationPeopleController {

	
	private static final Logger logger = LogManager.getLogger(FireStationPeopleController.class);
	
	@Autowired
    FireStationPeopleService firestationPeopleService;

    /*@GetMapping("/firestationpeople/{stationNumber}")
    public FireStationPeopleList getPeopleFromFirestationNumber(@PathParam("stationNumber") String stationNumber) {
        logger.info("response in return to the GET request on the endpoint / firestationpeople with the stationNumber parameter: " + stationNumber);
        return firestationPeopleService.getPeopleFromFirestationNumber(stationNumber);
    }*/
}