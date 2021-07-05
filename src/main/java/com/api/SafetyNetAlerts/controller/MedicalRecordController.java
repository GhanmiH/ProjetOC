package com.api.SafetyNetAlerts.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.service.MedicalRecordService;


@RestController
public class MedicalRecordController {

	 private static final Logger logger = LogManager.getLogger(MedicalRecordController.class);
	 
	 @Autowired
	    private MedicalRecordService medicalrecordservice;
	 
	 @GetMapping("/medicalrecords")
	    public Iterable<MedicalRecord> getAllMedicalRecords(){

	        logger.info("req Get endpoint MedicalRecords");
	        Iterable<MedicalRecord> medicalRecordsIterable = medicalrecordservice.getAllMedicalRecords();
	        logger.info("req next Get endpoint MedicalRecords");
	        return medicalRecordsIterable;
	    }
}
