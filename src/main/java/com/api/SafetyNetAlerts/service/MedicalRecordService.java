package com.api.SafetyNetAlerts.service;

import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.repository.MedicalRecordRepository;

@Service
public class MedicalRecordService {

	private static final Logger logger = LogManager.getLogger(MedicalRecordService.class);

	@Autowired
	private MedicalRecordRepository medicalRecordRepository;

	public Iterable<MedicalRecord> getAllMedicalRecords() {
		return medicalRecordRepository.findAll();

	}

	public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
		return medicalRecordRepository.save(medicalRecord);
	}

	public MedicalRecord getMedicalRecordFromLastNameAndFirstName(String lastName, String firstName) {
		return medicalRecordRepository.findMedicalRecordByLastNameAndFirstName(lastName, firstName);

	}

	public void deleteMedicalRecord(MedicalRecord medicalRecord) {
		medicalRecordRepository.deleteMedicalRecordsByFirstNameAndLastNameAllIgnoreCase(medicalRecord.getFirstName(),
				medicalRecord.getLastName());
	}

	public Optional<MedicalRecord> getMedicalRecordByFirstNameAndLastName(String firstname, String lastname) {
		try {
			return medicalRecordRepository.findByFirstNameAndLastNameAllIgnoreCase(firstname, lastname);
		} catch (Exception exception) {
			logger.error("Error while getting a list of medical records  : " + exception.getMessage()
					+ " Stack Trace + " + exception.getStackTrace());
			return null;
		}
	}

	public void deleteMedicalRecordByLastNameAndFirstName(String lastName, String firstName) {
		medicalRecordRepository.deleteMedicalRecordByLastNameAndFirstName(lastName, firstName);

	}

}