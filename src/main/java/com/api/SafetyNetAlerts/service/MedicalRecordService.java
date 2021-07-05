package com.api.SafetyNetAlerts.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.repository.MedicalRecordRepository;
import com.api.SafetyNetAlerts.repository.PersonRepository;



@Service
public class MedicalRecordService {
	
	private static final Logger logger = LogManager.getLogger(MedicalRecordService.class);

	@Autowired
	private MedicalRecordRepository medicalRecordRepository;
	 /**
     * Returns all of the existing medical record
     *
     */
	public Iterable<MedicalRecord> getAllMedicalRecords() {
		try {
			return medicalRecordRepository.findAll();
		} catch (Exception exception) {
			logger.error("Error while getting a list of medical records  : " + exception.getMessage() + " Stack Trace + " + exception.getStackTrace());
			return null;
		}
	}
}