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
	private  MedicalRecordRepository medicalRecordRepository;
	

	/**
	 * Returns all of the existing medical record
	 *
	 */
	public Iterable<MedicalRecord> getAllMedicalRecord() {
		
			return medicalRecordRepository.findAll();
		
	}


	/**
	 * add a medical record
	 * 
	 * @param medicalRecord
	 * @return a medical
	 */
	public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord) {
		if (medicalRecord != null) {
			Optional<MedicalRecord> medicalRecordOptional = this.getMedicalRecordByPersonId(medicalRecord.getPersonId());
			if (medicalRecordOptional.isPresent()) {
				logger.error("Error while adding a  exist medical record:");
				return null;
			} else {
				try {
					medicalRecordRepository.save(medicalRecord);
				} catch (Exception exception) {
					logger.error("Error while adding a  medical records:" + exception.getMessage() + " StackTrace : "
							+ exception.getStackTrace());
					return null;
				}
			}
		}
		return medicalRecord;
	}

	/**
	 * Get medical record by firstName and lastName
	 * 
	 * @param firstname
	 * @return medical record if found it
	 */
	public Optional<MedicalRecord> getMedicalRecordByPersonId(int i) {
		try {
			return Optional.empty();
		} catch (Exception exception) {
			logger.error("Error while getting a list of medical records  : " + exception.getMessage()
					+ " Stack Trace + " + exception.getStackTrace());
			return null;
		}
	}

	 /**
     * Update medical record
     * @param medicalRecord
     * @return medical record
     */
    public MedicalRecord updateMedicalRecord( MedicalRecord medicalRecord) {
        if (medicalRecord!=null) {
            Optional<MedicalRecord> medicalRecordOptional = this.getMedicalRecordByPersonId(medicalRecord.getPersonId());

            if (medicalRecordOptional.isPresent()) {
                MedicalRecord medicalRecordToUpdate = medicalRecordOptional.get();

                medicalRecordToUpdate.setMedications(medicalRecord.getMedications());
                medicalRecordToUpdate.setAllergies(medicalRecord.getAllergies());
                

                try {
                    medicalRecordRepository.save(medicalRecordToUpdate);
                    return medicalRecordToUpdate;
                } catch (Exception exception) {
                    logger.error("Error while updating a medical record : " + exception.getMessage() + " StackTrace : " + exception.getStackTrace());
                    return null;
                }
            } else {
                logger.error("Error while updating a medical record : this person doesen't exist");
                return null;
            }
        }
        else
        {
            logger.error("Error while updating a medical record : null object");
            return null;
        }
    }

    /**
     * delete medical record by firstName and lastName
     * @param medicalRecord
     * @return null in case have a problem
     */
    public void deleteMedicalRecord(MedicalRecord medicalRecord) {
            medicalRecordRepository.deleteMedicalRecordsByPersonId(medicalRecord.getPersonId());
    }

    public  MedicalRecord getMedicalRecordFromPerson(String person) {
        
    	try{
    		return medicalRecordRepository.findMedicalRecordByPersonId(person);
    	} catch (Exception exception) {
    		logger.error("Error while getting a person: " + exception.getMessage() + " Stack Trace + "
					+ exception.getStackTrace());
			return null;
		}
	}


	public Iterable<MedicalRecord> getAllergiesByMedicalRecordId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}