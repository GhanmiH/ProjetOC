package com.api.SafetyNetAlerts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.SafetyNetAlerts.model.FireList;
import com.api.SafetyNetAlerts.service.FireService;
import com.api.SafetyNetAlerts.service.FireStationService;
import com.api.SafetyNetAlerts.service.PersonService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class FireController {
   /* @Autowired
    PersonService personService;
    @Autowired
    FireStationService firestationService;
    @Autowired
    FireService fireService;

    private static final Logger logger = LogManager.getLogger(FireController.class);
    
    @GetMapping("/fire")
    public FireList getPeopleWhenFire(@PathParam("address") String address) {
        logger.info("requête GET sur le endpoint /fire avec le paramètre address: " + address);
        return fireService.getPeopleWhenFire(address);
    }*/
}