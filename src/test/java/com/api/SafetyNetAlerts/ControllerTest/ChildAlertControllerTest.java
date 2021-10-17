package com.api.SafetyNetAlerts.ControllerTest;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.api.SafetyNetAlerts.model.ChildAlert;
import com.api.SafetyNetAlerts.model.ChildAlertList;
import com.api.SafetyNetAlerts.model.Medications;
import com.api.SafetyNetAlerts.service.ChildAlertService;
import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ChildAlertControllerTest {

	 @Autowired
	    MockMvc mockMvc;
	    @MockBean
	    ChildAlertService childAlertService;

	    @Test
	    public void testPhoneAlert() throws Exception {
	        when(childAlertService.getChildFromAddress(anyString())).thenReturn(any(ChildAlertList.class));
	        mockMvc.perform(get("/childAlert?address=1509 Culver St"))
	                .andExpect(status().isOk());

	    }
	    @Test
	    public void testToString()
	    {
	        ToStringVerifier.forClass(ChildAlert.class)
	                      .withClassName(NameStyle.SIMPLE_NAME)
	                      .verify();
	    }
}
