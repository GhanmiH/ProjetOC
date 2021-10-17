package com.api.SafetyNetAlerts.ServiceTest;
/*
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.api.SafetyNetAlerts.model.Allergies;
import com.api.SafetyNetAlerts.model.MedicalRecord;
import com.api.SafetyNetAlerts.repository.AllergiesRepository;
import com.api.SafetyNetAlerts.service.AllergieService;
import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;

@SpringBootTest
@AutoConfigureMockMvc
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
	    @Test
	    public void testToString()
	    {
	        ToStringVerifier.forClass(Allergies.class)
	                      .withClassName(NameStyle.SIMPLE_NAME)
	                      .verify();
	    }
	   
}*/
