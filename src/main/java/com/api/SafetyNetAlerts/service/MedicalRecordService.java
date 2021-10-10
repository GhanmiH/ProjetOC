package com.api.SafetyNetAlerts.service;

import java.util.List;
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
	public MedicalRecordRepository medicalRecordRepository;

	public Iterable<MedicalRecord> getAllMedicalRecords() {

		return medicalRecordRepository.findAll();

	}

	public void saveMedicalRecords(List<MedicalRecord> medicalRecords) {
		medicalRecordRepository.saveAll(medicalRecords);
	}

	public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
		return medicalRecordRepository.save(medicalRecord);
	}

	public MedicalRecord updateMedicalRecord(final MedicalRecord medicalRecord) {
		if (medicalRecord != null) {
			Optional<MedicalRecord> medicalRecordOptional = this
					.getMedicalRecordByFirstNameAndLastName(medicalRecord.getFirstName(), medicalRecord.getLastName());

			if (medicalRecordOptional.isPresent()) {
				MedicalRecord medicalRecordToUpdate = medicalRecordOptional.get();

				medicalRecordToUpdate.setMedications(medicalRecord.getMedications());
				medicalRecordToUpdate.setAllergies(medicalRecord.getAllergies());

				try {
					medicalRecordRepository.save(medicalRecordToUpdate);
					return medicalRecordToUpdate;
				} catch (Exception exception) {
					logger.error("Error while updating a medical records : " + exception.getMessage() + " StackTrace : "
							+ exception.getStackTrace());
					return null;
				}
			} else {
				logger.error("Error while updating a medical records : this person doesen't exist");
				return null;
			}
		} else {
			logger.error("Error while updating a medical records : null object");
			return null;
		}
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

	public MedicalRecord getMedicalRecordFromLastNameAndFirstName(String lastName, String firstName) {
		return medicalRecordRepository.findMedicalRecordByLastNameAndFirstName(lastName, firstName);

	}

	public void deleteMedicalRecord(MedicalRecord medicalRecord) {
		medicalRecordRepository.deleteMedicalRecordsByFirstNameAndLastNameAllIgnoreCase(medicalRecord.getFirstName(),
				medicalRecord.getLastName());
	}

}