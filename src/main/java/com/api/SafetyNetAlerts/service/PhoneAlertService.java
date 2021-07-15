package com.api.SafetyNetAlerts.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.model.Person;

@Service
public class PhoneAlertService {

	private static final Logger logger = LogManager.getLogger(PhoneAlertService.class);
	
    @Autowired
    FireStationService firestationService;
    @Autowired
    PersonService personService;

public List<String> phoneAlert(String firestationNumber) {
    Iterable<FireStation> firestations = firestationService.getFirestationsFromStationNumber(firestationNumber);
    List<String> phoneList = new ArrayList<String>();
        for (FireStation firestation2: firestations
             ) {

            Iterable<Person> personList = personService.getPersonFromAddress(firestation2.getAddress());
            for (Person person: personList
                 ) {
                String phone = person.getPhone();
                if (!phoneList.contains(phone)) {
                    phoneList.add(phone);
                }
            }

        }
        logger.info("réponse en retour à la requête sur le endpoint /phoneAlert avec paramètre firestation: " + firestationNumber);
        return phoneList;

    }
}