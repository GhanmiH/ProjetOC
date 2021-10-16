package com.api.SafetyNetAlerts.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SafetyNetAlerts.model.Allergies;
import com.api.SafetyNetAlerts.repository.AllergiesRepository;


@Service
public class AllergieService {

	private static final Logger logger = LogManager.getLogger(AllergieService.class);

	@Autowired
	private AllergiesRepository allergieRepository;

	/**
	 * Returns all of the existing allergies
	 *
	 */
	public Iterable<Allergies> getAllAllergies() {
		
			return allergieRepository.findAll();
		
	}

	/**
	 * add an allergy
	 * 
	 * @param allergie to add
	 * @return allergie added, or null object
	 * @throws Exception
	 */
	public Allergies addAllergy(Allergies allergie) throws Exception {

		try {
			allergieRepository.save(allergie);
		} catch (Exception exception) {

			throw new Exception("The allergy could not be added:" + exception.getMessage());
		}
		return allergie;
	}
}
