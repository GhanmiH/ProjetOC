package com.api.SafetyNetAlerts.ControllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.api.SafetyNetAlerts.model.ChildAlertList;
import com.api.SafetyNetAlerts.service.ChildAlertService;

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

}
