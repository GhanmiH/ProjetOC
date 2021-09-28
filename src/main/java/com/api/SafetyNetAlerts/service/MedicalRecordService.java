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

	/**
	 * Returns all of the existing people
	 *
	 */
	public Iterable<MedicalRecord> getAllMedicalRecords() {
		
			return medicalRecordRepository.findAll();
		
	}

	/**
	 * add a medicalRecord
	 * 
	 * @param medicalRecord to add
	 * @return medicalRecord added, or null object
	 * @throws Exception
	 */
	public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord) throws Exception {

		try {
			medicalRecordRepository.save(medicalRecord);
		} catch (Exception exception) {

			throw new Exception("The medicalRecord could not be added:" + exception.getMessage());
		}
		return medicalRecord;
	}

	/**
     * Update medical records
     * @param medicalRecord
     * @return medical records
     */
    public MedicalRecord updateMedicalRecord(final MedicalRecord medicalRecord) {
        if (medicalRecord!=null) {
            Optional<MedicalRecord> medicalRecordOptional = this.getMedicalRecordByFirstNameAndLastName(medicalRecord.getFirstName(), medicalRecord.getLastName());

            if (medicalRecordOptional.isPresent()) {
                MedicalRecord medicalRecordToUpdate = medicalRecordOptional.get();

                medicalRecordToUpdate.setMedications(medicalRecord.getMedications());
                medicalRecordToUpdate.setAllergies(medicalRecord.getAllergies());

                try {
                    medicalRecordRepository.save(medicalRecordToUpdate);
                    return medicalRecordToUpdate;
                } catch (Exception exception) {
                    logger.error("Error while updating a medical records : " + exception.getMessage() + " StackTrace : " + exception.getStackTrace());
                    return null;
                }
            } else {
                logger.error("Error while updating a medical records : this person doesen't exist");
                return null;
            }
        }
        else
        {
            logger.error("Error while updating a medical records : null object");
            return null;
        }
    }
    /**
     * delete medical record by firstName and lastName
     * @param medicalRecords
     * @return null in case have a problem
     */
    public void deleteMedicalRecord(MedicalRecord medicalRecord) {
            medicalRecordRepository.deleteMedicalRecordsByFirstNameAndLastNameAllIgnoreCase(medicalRecord.getFirstName(), medicalRecord.getLastName());
    }
    /**
     * Get medical record by firstName and lastName
     * @param firstname
     * @param lastname
     * @return medical records if found it
     */
    public Optional<MedicalRecord> getMedicalRecordByFirstNameAndLastName(String firstname, String lastname) {
        try {
            return medicalRecordRepository.findByFirstNameAndLastNameAllIgnoreCase(firstname, lastname);
        } catch (Exception exception) {
            logger.error("Error while getting a list of medical records  : " + exception.getMessage() + " Stack Trace + " + exception.getStackTrace());
            return null;
        }
    }
}