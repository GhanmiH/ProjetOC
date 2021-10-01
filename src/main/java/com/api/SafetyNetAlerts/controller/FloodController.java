package com.api.SafetyNetAlerts.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.SafetyNetAlerts.service.FloodService;

import java.util.List;

@RestController
public class FloodController {

    @Autowired
    FloodService floodService;

    private static final Logger logger = LogManager.getLogger(FloodController.class);

    @GetMapping("/flood/stations")
    public List getPeopleWhenFloodFromStationNumber(@RequestParam("stations") List<String> stationNumber) {
        logger.info("requête GET sur le endpoint /flood/stations avec le paramètre stationNumber: " + stationNumber);
        return floodService.getPeopleWhenFloodFromStationNumber(stationNumber);
    }

}
