package com.api.SafetyNetAlerts.ControllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.api.SafetyNetAlerts.model.FireStationPeopleList;
import com.api.SafetyNetAlerts.service.FireStationPeopleService;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FireStationPeopleControllerTest {

	@Autowired
    MockMvc mockMvc;
    @MockBean
    FireStationPeopleService firestationPeopleService;

    @Test
    public void testGetPeopleWhenFire() throws Exception {
        when(firestationPeopleService.getPeopleFromFirestationNumber(anyString())).thenReturn(any(FireStationPeopleList.class));
        mockMvc.perform(get("/firestations?stationNumber=1"))
                .andExpect(status().isOk());
    }
}
