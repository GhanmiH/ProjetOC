package com.api.SafetyNetAlerts.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FireStationPeopleService {

    @Autowired
    FireStationService firestationService;
    @Autowired
    PersonService personService;
    /*@Autowired
    MedicalRecordService medicalRecordService;*/

    private static final Logger logger = LogManager.getLogger(FireStationPeopleService.class);

    /**
     * récupère la liste des personnes rattachés à une caserne et compte les adultes et enfants
     * @param stationNumber le numéro de la caserne
     * @return une liste comprenant le décompte des adultes et enfants ainsi que noms prénoms adresse et téléphone de chacun
     */

   
}