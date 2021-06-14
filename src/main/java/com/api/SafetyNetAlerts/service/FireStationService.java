package com.api.SafetyNetAlerts.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SafetyNetAlerts.SafetyNetAlertsApplication;
import com.api.SafetyNetAlerts.repository.FireStationRepository;




@Service
public class FireStationService {
	
	private static final Logger logger = LogManager.getLogger(FireStationService.class);

	@Autowired
    private FireStationRepository fireStationRepository;
}
