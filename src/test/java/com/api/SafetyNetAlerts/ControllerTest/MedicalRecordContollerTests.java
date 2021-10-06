package com.api.SafetyNetAlerts.ControllerTest;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.api.SafetyNetAlerts.model.Allergies;
import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.model.Medications;
import com.api.SafetyNetAlerts.service.AllergieService;
import com.api.SafetyNetAlerts.service.FireStationService;
import com.api.SafetyNetAlerts.service.MedicalRecordService;
import com.api.SafetyNetAlerts.service.MedicationService;


@SpringBootTest
@AutoConfigureMockMvc

class MedicalRecordContollerTests {
	
	@Autowired
    MockMvc mockMvc;
    @MockBean
    MedicalRecordService medicalrecordService;
    @MockBean
    AllergieService allergiesService;
    @MockBean
    MedicationService medicationsService;

    MedicalRecord medicalrecord;
    String medicalrecordJson;
    List<MedicalRecord> medicalrecordList;
    

    Allergies allergie;
    String allergieJson;
    List<Allergies> allergiesList;

    Medications medication;
    String medicationJson;
    List<FireStation> medicationList;
    
    @BeforeEach
    void init() {
    	medicalrecord = new MedicalRecord();
    	medicalrecord.setFirstName("Lilia");
    	medicalrecord.setLastName("Ghanmi");
    	//medicalrecord.setBirthdate(01/01/1985);
    	medicalrecord.setAllergies(allergiesList);
    	medicalrecord.setMedications(null);

    	 medicalrecordJson = "{\n" +
                 "        \"firstName\": \"Lilia\",\n" +
                 "        \"lastName\": \"Ghanmi\",\n" +
                // "        \"birthdate\": \"01-01-1985\",\n" +
                 "        \"allergies\": [\"aznol:350mg\", \"hydrapermazol:100mg\"],\n" +
                 "        \"medications\": [\"aznol:350mg\", \"hydrapermazol:100mg\"]\n" +
                 "    }";
    	 medicalrecordList = new ArrayList<>();
    	 medicalrecordList.add(medicalrecord);
    	 allergiesList = new ArrayList<>();
    	 allergiesList.add(allergie);
    	 medicationList = new ArrayList<>();
    	// medicationList.add(medication);
    	 
      
    }
    
}
