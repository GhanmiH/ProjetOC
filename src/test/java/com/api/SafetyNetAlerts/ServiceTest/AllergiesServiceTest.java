package com.api.SafetyNetAlerts.ServiceTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.api.SafetyNetAlerts.model.Allergies;
import com.api.SafetyNetAlerts.repository.AllergiesRepository;
import com.api.SafetyNetAlerts.service.AllergieService;

@SpringBootTest
class AllergiesServiceTest {

	 @MockBean
	    AllergiesRepository allergieRepository;
	    @Autowired
	    AllergieService allergieService ;
	   

	    @Test
	    public void getAllAllergie_ShouldUseAllergiesRepository() {
	    	allergieService.getAllAllergies();
	        verify(allergieRepository, times(1)).findAll();
	    }

	    @Test
	    public void addAllergie_ShouldUseAllergiesRepository() throws Exception {
	    	Allergies allergie = new Allergies();
	    	allergieService.addAllergy(allergie);
	        verify(allergieRepository, times(1)).save(allergie);
	    }
}
