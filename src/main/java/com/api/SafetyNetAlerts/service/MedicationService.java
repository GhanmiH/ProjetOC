package com.api.SafetyNetAlerts.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SafetyNetAlerts.model.Medications;
import com.api.SafetyNetAlerts.repository.MedicationRepository;


@Service
public class MedicationService {

	private static final Logger logger = LogManager.getLogger(MedicationService.class);
	
	@Autowired
	private MedicationRepository medicationRepository;

	/**
	 * Returns all of the existing people
	 *
	 */
	public Iterable<Medications> getAllMedications() {
		
			return medicationRepository.findAll();
		
	}

	/**
	 * add a medication
	 * 
	 * @param medication to add
	 * @return medication added, or null object
	 * @throws Exception
	 */
	public Medications addMedication(Medications medication) throws Exception {

		try {
			medicationRepository.save(medication);
		} catch (Exception exception) {

			throw new Exception("The medication could not be added:" + exception.getMessage());
		}
		return medication;
	}
}
