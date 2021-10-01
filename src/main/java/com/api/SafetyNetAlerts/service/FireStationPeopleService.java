package com.api.SafetyNetAlerts.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.model.FireStationPeople;
import com.api.SafetyNetAlerts.model.FireStationPeopleList;
import com.api.SafetyNetAlerts.model.Person;

import java.util.ArrayList;
import java.util.List;

@Service
public class FireStationPeopleService {

    @Autowired
    FireStationService fireStationService;
    @Autowired
    PersonService personService;
    /*@Autowired
    MedicalRecordService medicalRecordService;*/

    private Logger logger = LogManager.getLogger(FireStationPeopleService.class);

    
    public FireStationPeopleList getPeopleFromFirestationNumber(String stationNumber) {

        List<FireStationPeople> firestationPeopleList = new ArrayList<>();
        FireStationPeopleList firestationPeopleList2 = new FireStationPeopleList();

        int adultCount = 0;
        int childCount = 0;

        Iterable<FireStation> firestations = fireStationService.getFirestationsFromStationNumber(stationNumber);

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
                FireStationPeople firestationPeople = new FireStationPeople();
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
        logger.info("réponse en retour à la requête GET sur le endpoint /firestation avec le paramètre stationNumber: " + stationNumber);
        return firestationPeopleList2;


    }
}
