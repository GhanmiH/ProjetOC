package com.api.SafetyNetAlerts.ControllerTest;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.api.SafetyNetAlerts.model.FloodList;
import com.api.SafetyNetAlerts.model.FloodPeople;
import com.api.SafetyNetAlerts.service.FloodService;
import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class FloodControllerTest {

	 @Autowired
	    MockMvc mockMvc;
	    @MockBean
	    FloodService floodService;

	    @Test
	    public void testPhoneAlert() throws Exception {
	        when(floodService.getPeopleWhenFloodFromStationNumber(anyList())).thenReturn(anyList());
	        mockMvc.perform(get("/flood/stations?stations=1,2"))
	                .andExpect(status().isOk());

	    }
	    @Test
	    public void testToString()
	    {
	        ToStringVerifier.forClass(FloodPeople.class)
	                      .withClassName(NameStyle.SIMPLE_NAME)
	                      .verify();
	    }
	    @Test
	    public void test2ToString()
	    {
	        ToStringVerifier.forClass(FloodList.class)
	                      .withClassName(NameStyle.SIMPLE_NAME)
	                      .verify();
	    }
	    

}
