package com.api.SafetyNetAlerts.ControllerTest;

import com.api.SafetyNetAlerts.model.FireStationPeople;
import com.api.SafetyNetAlerts.model.FireStationPeopleList;
import com.api.SafetyNetAlerts.model.Medications;
import com.api.SafetyNetAlerts.service.PhoneAlertService;
import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class PhoneAlertControllerTest {

	@Autowired
    MockMvc mockMvc;
    @MockBean
    PhoneAlertService phoneAlertService;

    @Test
    public void testGetPhoneAlert() throws Exception {
        when(phoneAlertService.getphoneAlert(anyString())).thenReturn(anyList());
        mockMvc.perform(get("/phoneAlert?fireStation=1"))
                .andExpect(status().isOk());

    }
    @Test
    public void testToString()
    {
        ToStringVerifier.forClass(FireStationPeople.class)
                      .withClassName(NameStyle.SIMPLE_NAME)
                      .verify();
    }
    @Test
    public void test2ToString()
    {
        ToStringVerifier.forClass(FireStationPeopleList.class)
                      .withClassName(NameStyle.SIMPLE_NAME)
                      .verify();
    }
}
