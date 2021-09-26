package com.api.SafetyNetAlerts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;
 

@RestController
public class FireStationPeopleController {

	
	private static final Logger logger = LogManager.getLogger(FireStationPeopleController.class);
	
//	@Autowired
   // FireStationPeopleService firestationPeopleService;

    /*@GetMapping("/firestationpeople/{stationNumber}")
    public FireStationPeopleList getPeopleFromFirestationNumber(@PathParam("stationNumber") String stationNumber) {
        logger.info("response in return to the GET request on the endpoint / firestationpeople with the stationNumber parameter: " + stationNumber);
        return firestationPeopleService.getPeopleFromFirestationNumber(stationNumber);
    }*/
}