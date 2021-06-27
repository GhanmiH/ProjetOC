package com.api.SafetyNetAlerts.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.repository.MedicalRecordRepository;



@Service
public class MedicalRecordService {
	
	private static final Logger logger = LogManager.getLogger(MedicalRecordService.class);

	@Autowired
    private MedicalRecordRepository medicalrecordrepository;

	public Iterable<MedicalRecord> getMedicalRecord() {
		try {
		return medicalrecordrepository.findAll();
		 } catch (Exception exception) {
	            logger.error("Error while getting list of person : " + exception.getMessage() + " Stack Trace + " + exception.getStackTrace());
		return null;
	}
	}

	 /**
     * Returns all of the existing medical record
     *
     */
	public Iterable<MedicalRecord> getAllMedicalRecord() {
		
		return null;
	}
}