package com.api.SafetyNetAlerts.ControllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.service.FireStationService;

@SpringBootTest
@AutoConfigureMockMvc
class FireStationControllerTests {
	@Autowired
    MockMvc mockMvc;
    @MockBean
    FireStationService firestationService;

    FireStation firestation;
    String firestationJson;
    List<FireStation> firestationList;

    @BeforeEach
    void init() {
        firestation = new FireStation();
        firestation.setAddress("rue de Paris");
        firestation.setStation("1");

        firestationJson ="{\n" +
                "        \"address\": \"rue de Paris\",\n" +
                "        \"station\": \"1\"\n" +
                "    }";

        firestationList = new ArrayList<>();
        firestationList.add(firestation);
    }
    @Test
    public void testGetAllStations() throws Exception {
        when(firestationService.getFireStations()).thenReturn(firestationList);
        mockMvc.perform(get("/firestation"))
                .andExpect(status().isOk());
    }
    @Test
    public void testAddFirestation() throws Exception {
        when(firestationService.addFirestation((FireStation) any(FireStation.class))).thenReturn(firestation);
        mockMvc.perform(post("/firestation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(firestationJson))
                .andExpect(status().isOk());
    }
    @Test
    public void testUpdateAddressForFireStation() throws Exception {
        when(firestationService.updateFireStation((FireStation) any(FireStation.class))).thenReturn(firestation);
        mockMvc.perform(put("/firestation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(firestationJson))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testDeleteFirestationByAddress() throws Exception {
        when(firestationService.getFirestationFromAddress(anyString())).thenReturn(firestationList);
        mockMvc.perform(delete("/firestation/address/test"))
                .andExpect(status().isOk());
    }


}
