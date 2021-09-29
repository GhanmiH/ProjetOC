package com.api.SafetyNetAlerts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.SafetyNetAlerts.model.FireStationPeopleList;
import com.api.SafetyNetAlerts.service.FireStationPeopleService;

import javax.websocket.server.PathParam;

@RestController
public class FireStationPeopleController {

    @Autowired
    FireStationPeopleService fireStationPeopleService;

    private Logger logger = LogManager.getLogger(FireStationController.class);

    @GetMapping("/firestations")
    public FireStationPeopleList getPeopleFromFirestationNumber(@PathParam("stationNumber") String stationNumber) {
        logger.info("requête GET sur le endpoint /firestation avec le paramètre stationNumber: " + stationNumber);
        return fireStationPeopleService.getPeopleFromFirestationNumber(stationNumber);
    }
    
}