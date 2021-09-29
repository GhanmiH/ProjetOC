package com.api.SafetyNetAlerts.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.repository.FireStationRepository;

import lombok.Data;


@Data
@Service
public class FireStationService {

	private static final Logger logger = LogManager.getLogger(FireStationService.class);

	@Autowired
	private FireStationRepository firestationrepository;

	
	public Iterable<FireStation> getFireStations() {
		return firestationrepository.findAll();

	}

	/**
	 * add a fire station
	 * 
	 * @param firestation to add
	 * @return firestation added, or null object
	 * @throws Exception
	 */
	public FireStation addFirestation(FireStation firestation) throws Exception {
		try {
			firestationrepository.save(firestation);
		} catch (Exception exception) {

			throw new Exception("The fire station could not be added:" + exception.getMessage());
		}
		return firestation;
	}

	/**
     * update station number
     *
     * @param fireStation
     * @re4turn null if has a problem when updating
     *
     */
    public FireStation updateFireStation(FireStation fireStation) {
        if (fireStation != null) {
            Optional<FireStation> fireStationOptional = this.getFireStationByAddressIgnoreCase(fireStation.getAddress());

            if (fireStationOptional  .isPresent()) {
            	FireStation firestationToUpdate = fireStationOptional.get();

            	firestationToUpdate.setAddress(fireStation.getAddress());
            	firestationToUpdate.setstation(fireStation.getStation());
                    try {
                        firestationrepository.save(firestationToUpdate);
                    } catch (Exception exception) {
                        logger.error("error when updating Fire station:" + exception.getMessage() +
                                " Stack Trace : " + exception.getStackTrace());
                        return null;
                    }
                }
                return fireStation;
            }
		return fireStation;
        }

    private Optional<FireStation> getFireStationByAddressIgnoreCase(String address) {
		try {
			return firestationrepository.findByAddressAllIgnoreCase(address);
		} catch (Exception exception) {
			logger.error("Error while getting a firestation: " + exception.getMessage() + " Stack Trace + "
					+ exception.getStackTrace());
			return null;
		}
	}

	/**
	 * delete one person if exist
	 * 
	 * @param person to delete
	 * @return
	 * @return
	 */
	public FireStation deleteFirestation(FireStation firestation) {
		firestationrepository.removeByAddressAndStation(firestation.getAddress(), firestation.getStation());
		return firestation;
	}

	
	public Iterable<FireStation> getFirestationsFromStationNumber(String station) {
        return firestationrepository.findAllByStation(station);
    }
}