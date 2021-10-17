package com.api.SafetyNetAlerts.ControllerTest;


import org.apache.commons.lang.builder.ToStringStyle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyleContext.NamedStyle;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.api.SafetyNetAlerts.model.Allergies;

import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.model.Medications;
import com.api.SafetyNetAlerts.model.Person;
import com.api.SafetyNetAlerts.service.MedicalRecordService;
import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import com.sun.xml.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

@SpringBootTest
@AutoConfigureMockMvc

class MedicalRecordContollerTests {
	
	 @Autowired
	    MockMvc mockMvc;
	    @MockBean
	    MedicalRecordService medicalRecordService;

	    MedicalRecord medicalRecord;
	    List<MedicalRecord> medicalRecordList;
	    String medicalRecordJson;
	   

	    @BeforeEach
	    void init() {

	        List<Allergies> allergiesList = new ArrayList<>();
	        Allergies allergie1 = new Allergies();
	        Allergies allergie2 = new Allergies();
	        allergiesList.add(allergie1);
	        allergiesList.add(allergie2);

	        List<Medications> medicationsList = new ArrayList<>();
	        Medications medication1 = new Medications();
	        Medications medication2 = new Medications();
	        medicationsList.add(medication1);
	        medicationsList.add(medication2);

	        medicalRecord = new MedicalRecord();
	        medicalRecord.setMedications(medicationsList);
	        medicalRecord.setBirthdate (LocalDate.parse("01/01/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	       
	        medicalRecord.setAllergies(allergiesList);
	        medicalRecord.setFirstName("test");
	        medicalRecord.setLastName("test");
	        medicalRecordList = new ArrayList<>();
	        medicalRecordList.add(medicalRecord);
	        
	        medicalRecordJson = "{\n" +
	                "        \"firstName\": \"Eric\",\n" +
	                "        \"lastName\": \"Cadigan\",\n" +
	                "        \"birthdate\": \"01/01/2000\",\n" +
	                "        \"allergies\": [\"aznol:350mg\", \"hydrapermazol:100mg\"],\n" +
	                "        \"medications\": [\"aznol:350mg\", \"hydrapermazol:100mg\"]\n" +
	                "    }";
	       

	    }

	    @Test
	    public void testGetMedicalRecordFromLastNameAndFirstName() throws Exception {
	        when(medicalRecordService.getMedicalRecordFromLastNameAndFirstName(anyString(), anyString())).thenReturn(medicalRecord);
	        mockMvc.perform(get("/medicalRecord"))
	                .andExpect(status().isOk());
	    }
	   
	    @Test
	    public void testCreateMedicalRecord() throws Exception {
	        when(medicalRecordService.saveMedicalRecord((MedicalRecord)any(MedicalRecord.class))).thenReturn(medicalRecord);
	        mockMvc.perform(post("/medicalRecord")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(medicalRecordJson))
	                .andExpect(status().isOk());
	    }

	     @Test
    public void testUpdateMedicalRecordByLastNameAndFirstName() throws Exception {
        when(medicalRecordService.getMedicalRecordFromLastNameAndFirstName(anyString(), anyString())).thenReturn(medicalRecord);
        when(medicalRecordService.saveMedicalRecord((MedicalRecord)any(MedicalRecord.class))).thenReturn(medicalRecord);
        mockMvc.perform(put("/medicalRecord/test/test")
                .contentType(MediaType.APPLICATION_JSON)
                .content(medicalRecordJson))
                .andExpect(status().isOk());
    }

	  
	    @Test
	    public void testDeleteMedicalRecordByLastNameAndFirstName() throws Exception {
	        when(medicalRecordService.getMedicalRecordFromLastNameAndFirstName(anyString(), anyString())).thenReturn(medicalRecord);
	        mockMvc.perform(delete("/medicalRecord/test/test"))
	                .andExpect(status().isOk());
	    }
	    @Test
	    public void testToString()
	    {
	        ToStringVerifier.forClass(MedicalRecord.class)
	                      .withClassName(NameStyle.SIMPLE_NAME)
	                      .verify();
	    }
	   
}
