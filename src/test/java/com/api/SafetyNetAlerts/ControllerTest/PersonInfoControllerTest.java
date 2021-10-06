package com.api.SafetyNetAlerts.ControllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.api.SafetyNetAlerts.model.PersonInfo;
import com.api.SafetyNetAlerts.service.PersonInfoService;
import static org.mockito.Mockito.eq;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonInfoControllerTest {
	@Autowired
	MockMvc mockMvc;
	@MockBean
	PersonInfoService personinfoservice;
	
	@Test
	public void testGetAllInfoPerson() throws Exception {
		when(personinfoservice.getAllInfoPerson(anyString(), anyString()))
		.thenReturn(eq(any(PersonInfo.class)));
		mockMvc.perform(get("/personInfo?firstName=a&lastname=b"))
		.andExpect(status().isOk());
	}
	 @Test
	    public void testGetPeopleWhenFire() throws Exception {
	        when(personinfoservice.getEmailsFromCity(anyString())).thenReturn(anyList());
	        mockMvc.perform(get("/communityEmail?city=Culver"))
	                .andExpect(status().isOk());
	    }

}
