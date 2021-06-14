package com.api.SafetyNetAlerts.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SafetyNetAlerts.repository.MedicalRecordRepository;



@Service
public class MedicalRecordService {
	
	private static final Logger logger = LogManager.getLogger(MedicalRecordService.class);

	@Autowired
    private MedicalRecordRepository medicalRecordRepository;
}
