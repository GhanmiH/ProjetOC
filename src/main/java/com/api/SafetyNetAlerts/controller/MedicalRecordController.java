package com.api.SafetyNetAlerts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.service.MedicalRecordService;


@RestController
public class MedicalRecordController {
   
	
	private static final Logger logger = LogManager.getLogger(MedicalRecordController.class);

	@Autowired
     MedicalRecordService medicalRecordService;

    public MedicalRecordController (MedicalRecordService medicalRecordService){
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping("/medicalRecord")
    public Iterable<MedicalRecord> getAllMedicalRecords(){

        logger.info("req Get endpoint MedicalRecords");
        Iterable<MedicalRecord> medicalRecordsIterable = medicalRecordService.getAllMedicalRecords();
        logger.info("req next Get endpoint MedicalRecords");
        return medicalRecordsIterable;
    }


    @PostMapping("/medicalRecord")
	public MedicalRecord addFireStation(@RequestBody MedicalRecord medicalRecord) throws Exception {
		logger.info("req Put endpoint 'medicalRecord'");

		MedicalRecord updatedMedicalService = medicalRecordService.saveMedicalRecord(medicalRecord);
		if (updatedMedicalService != null) {
			logger.info("req next Put endpoint 'medicalrecord' ");
			return updatedMedicalService;
		} else {
			throw new Exception("medicalrecord.added.error");
		}
	}


    @PutMapping("/medicalRecord")
    public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) throws Exception {
        logger.info("req Put  endpoint medicalrecord");

        MedicalRecord updatedMedicalRecord = medicalRecordService.updateMedicalRecord(medicalRecord);
        if (updatedMedicalRecord != null) {
            logger.info("req Put  endpoint medicalrecord sent");
            return updatedMedicalRecord;
        } else {
            throw new Exception("medicalRecord.update.error");
        }
    }
    
    @DeleteMapping("/medicalRecord")
 
    public void deleteMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        logger.info("req Delete  endpoint medicalrecord");
        medicalRecordService.deleteMedicalRecord(medicalRecord);
    }
   
}