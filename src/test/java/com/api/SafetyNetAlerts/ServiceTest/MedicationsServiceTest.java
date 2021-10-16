package com.api.SafetyNetAlerts.ServiceTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.api.SafetyNetAlerts.model.Medications;
import com.api.SafetyNetAlerts.repository.MedicationRepository;
import com.api.SafetyNetAlerts.service.MedicationService;


@SpringBootTest
class MedicationsServiceTest {

	 @MockBean
	    MedicationRepository medicationRepository;
	    @Autowired
	    MedicationService medicationService ;
	   
	    @Test
	    public void getAllMedications_ShouldUseAllergiesRepository() {
	    	medicationService.getAllMedications();
	        verify(medicationRepository, times(1)).findAll();
	    }

	    @Test
	    public void addMedication_ShouldUseAllergiesRepository() throws Exception {
	    	Medications medication = new Medications();
	    	medicationService.addMedication(medication);
	        verify(medicationRepository, times(1)).save(medication);
	    }
}
