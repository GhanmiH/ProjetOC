package com.api.SafetyNetAlerts.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.model.FireStationPeopleList;
import com.api.SafetyNetAlerts.model.FirestationPeople;
import com.api.SafetyNetAlerts.model.Person;

import java.util.ArrayList;
import java.util.List;

@Service
public class FireStationPeopleService {

	@Autowired
    FireStationService firestationService;
    @Autowired
    PersonService personService;
    
	private static final Logger logger = LogManager.getLogger(FireStationPeopleService.class);
	
	  /**
     *retrieves the list of people attached to a barracks and counts adults and children
     * @param stationNumber the barracks number
     * @return a list including the count of adults and children as well as surnames first names, address and telephone number of each
     */

    public FireStationPeopleList getPeopleFromFirestationNumber(String stationNumber) {

        List<FirestationPeople> firestationPeopleList = new ArrayList<>();
        FireStationPeopleList firestationPeopleList2 = new FireStationPeopleList();

        int adultCount = 0;
        int childCount = 0;

        Iterable<FireStation> firestations = firestationService.getFirestationsFromStationNumber(stationNumber);

       for (FireStation firestation: firestations
             ) {
            Iterable<Person> persons = personService.getPersonFromAddress(firestation.getAddress());
            for (Person person : persons
                 ) {
                int age = personService.getAge(person.getLastName(), person.getFirstName());

                if (age>18) {
                    adultCount ++;
                } else {
                    childCount ++;
                }
                FirestationPeople firestationPeople = new FirestationPeople();
                firestationPeople.setFirstName(person.getFirstName());
                firestationPeople.setLastName(person.getLastName());
                firestationPeople.setAddress(person.getAddress());
                firestationPeople.setPhone(person.getPhone());
                firestationPeopleList.add(firestationPeople);
            }
        }
        firestationPeopleList2.setFirestationPeople(firestationPeopleList);
        firestationPeopleList2.setAdult(adultCount);
        firestationPeopleList2.setChild(childCount);
        logger.info("response in return to the GET request on the endpoint / firestationpeople with the stationNumber parameter: " + stationNumber);
        return firestationPeopleList2;


    }
}