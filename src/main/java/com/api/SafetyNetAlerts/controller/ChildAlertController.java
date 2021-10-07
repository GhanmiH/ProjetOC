package com.api.SafetyNetAlerts.controller;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.SafetyNetAlerts.model.ChildAlertList;
import com.api.SafetyNetAlerts.service.ChildAlertService;

@RestController
public class ChildAlertController {
   
	@Autowired
    ChildAlertService childAlertService;

	private static final Logger logger = LogManager.getLogger(ChildAlertController.class);

    @GetMapping("/childAlert")
    public ChildAlertList childAlert(@PathParam("address") String address) throws Exception {
        logger.info("requête sur le endpoint /childAlert avec le paramètre address: " + address);
        return childAlertService.getChildFromAddress(address);
    }
}
