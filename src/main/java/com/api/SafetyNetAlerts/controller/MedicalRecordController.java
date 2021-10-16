package com.api.SafetyNetAlerts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.service.MedicalRecordService;

@RestController
public class MedicalRecordController {

	private static final Logger logger = LogManager.getLogger(MedicalRecordController.class);

	@Autowired
	MedicalRecordService medicalRecordService;

	@GetMapping("/medicalRecord")
	public Iterable<MedicalRecord> getAllMedicalRecords() {

		logger.info("req Get endpoint MedicalRecords");
		Iterable<MedicalRecord> medicalRecordsIterable = medicalRecordService.getAllMedicalRecords();
		logger.info("req next Get endpoint MedicalRecords");
		return medicalRecordsIterable;
	}

	@PostMapping("/medicalRecord")
	public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		logger.info("requête POST sur le endpoint /medicalRecord avec le body medicalRecord: " + medicalRecord);
		return medicalRecordService.saveMedicalRecord(medicalRecord);
	}

	@PutMapping("/medicalRecord/{lastName}/{firstName}")
	public MedicalRecord updateMedicalRecordByLastNameAndFirstName(@PathVariable("lastName") String lastName,
			@PathVariable("firstName") String firstName, @RequestBody MedicalRecord medicalRecord) {
		logger.info("requête PUT sur le endpoint /medicalRecord avec les paramètres lastName: " + lastName
				+ " et firstName: " + firstName + " et le body" + medicalRecord);
		MedicalRecord m = medicalRecordService.getMedicalRecordFromLastNameAndFirstName(lastName, firstName);
		m.setAllergies(medicalRecord.getAllergies());
		m.setBirthdate(medicalRecord.getBirthdate());
		m.setMedications(medicalRecord.getMedications());
		medicalRecordService.saveMedicalRecord(m);
		return m;
	}

	@DeleteMapping("/medicalRecord/{lastName}/{firstName}")
    public void deleteMedicalRecordByLastNameAndFirstName(@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName) {
        logger.info("requête DELETE sur le endpoint /medicalRecord avec les paramètres lastName: " + lastName + " et firstName: " + firstName);
        medicalRecordService.deleteMedicalRecordByLastNameAndFirstName(lastName, firstName);
    }

}