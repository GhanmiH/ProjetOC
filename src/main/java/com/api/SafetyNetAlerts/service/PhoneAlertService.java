package com.api.SafetyNetAlerts.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.repository.FireStationRepository;
import com.api.SafetyNetAlerts.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class PhoneAlertService {

	//@Autowired
	//private PersonRepository personRepository;
	
	@Autowired
	FireStationService firestationService;

	@Autowired
	PersonService personService;

	@Autowired
	FireStationRepository firestationrepository;

	private Logger logger = LogManager.getLogger(PhoneAlertService.class);

	public List<String> getphoneAlert(String firestation) {
		Iterable<FireStation> firestations = firestationService.getFirestationsFromStationNumber(firestation);
		List<String> phoneList = new ArrayList<String>();
		for (FireStation firestation2 : firestations) {

			Iterable<Person> personList = personService.getPersonFromAddress(firestation2.getAddress());
			for (Person person : personList) {
				String phone = person.getPhone();
				if (!phoneList.contains(phone)) {
					phoneList.add(phone);
				}
			}

		}
		logger.info("réponse en retour à la requête sur le endpoint /phoneAlert avec paramètre firestation: "
				+ firestation);
		return phoneList;

	}
}
