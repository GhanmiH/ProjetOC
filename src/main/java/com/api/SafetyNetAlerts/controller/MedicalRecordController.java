package com.api.SafetyNetAlerts.controller;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.service.MedicalRecordService;

@RestController
public class MedicalRecordController {

	private static final Logger logger = LogManager.getLogger(MedicalRecordController.class);

	@Autowired
	private MedicalRecordService medicalrecordservice;

	@GetMapping("/medicalrecords")
	public Iterable<MedicalRecord> getAllMedicalRecord() {

		logger.info("req Get endpoint MedicalRecord");
		Iterable<MedicalRecord> medicalRecordsIterable = medicalrecordservice.getAllMedicalRecord();
		logger.info("req next Get endpoint MedicalRecord");
		return medicalRecordsIterable;
	}

	@PostMapping("/medicalRecord")
	public MedicalRecord addMedicalRecord(@Validated @RequestBody MedicalRecord medicalRecord) throws Exception {
		logger.info("req Post endpoint MedicalRecords");

		MedicalRecord createdMedicalRecord = medicalrecordservice.addMedicalRecord(medicalRecord);

		if (createdMedicalRecord != null) {
			logger.info("req Post endpoint MedicalRecords sent");
			return createdMedicalRecord;
		} else {
			throw new Exception("medicalRecord.insert.error");

		}
	}
	
	@PutMapping("/medicalRecord")
    public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) throws Exception {
        logger.info("req Put  endpoint 'medicalrecord'");

        MedicalRecord updatedMedicalRecord = medicalrecordservice.updateMedicalRecord(medicalRecord);
        if (updatedMedicalRecord != null) {
            logger.info("req Put  endpoint medicalrecord sent");
            return updatedMedicalRecord;
        } else {
            throw new Exception("medicalRecord.update.error");
        }
    }
	
	 @DeleteMapping("/medicalRecord")
	    @Transactional
	    public void deleteMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
	        logger.info("req Delete  endpoint medicalrecord");
	        medicalrecordservice.deleteMedicalRecord(medicalRecord);
	    }
}
