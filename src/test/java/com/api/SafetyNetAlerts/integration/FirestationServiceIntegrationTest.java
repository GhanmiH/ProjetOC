package com.api.SafetyNetAlerts.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.repository.FireStationRepository;
import com.api.SafetyNetAlerts.service.FireStationService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class FirestationServiceIntegrationTest {
	@Autowired
	 MockMvc mockMvc;
	@Autowired
    FireStationRepository firestationRepository;
    @Autowired
    FireStationService firestationService;

    @Test
    public void testGetFirestationsFromStationNumber() {
        List<FireStation> f = (List<FireStation>) firestationService.getFirestationsFromStationNumber("1");
        assertEquals("644 Gershwin Cir", f.get(0).getAddress());
    }
    @Test
    public void addFireStationItegrationTest() throws Exception {
        FireStation fireStation = new FireStation();
        fireStation.setStation("40");
        fireStation.setAddress("Adresse de la nouvelle caserne de pompiers n°40");

        firestationService.addFirestation(fireStation);

        Optional<FireStation> foundFireStation = firestationRepository.findByAddressAllIgnoreCase(fireStation.getAddress());

        assertThat(foundFireStation.get().getStation()).isEqualTo(fireStation.getStation());
        assertThat(foundFireStation.get().getAddress()).isEqualTo(fireStation.getAddress());

    }
    @Test
    public void testgetFirestationFromAddressIntegration()
    {
        FireStation fireStation = new FireStation();
        fireStation.setAddress("29 15th st");
        fireStation.setStation("2");
        firestationService.getFirestationFromAddress(fireStation.getAddress());
        FireStation foundFireStation = firestationRepository.findByAddressAllIgnoreCase(fireStation.getAddress()).get();
        assertThat(foundFireStation.getStation()).isEqualTo(fireStation.getStation());
        assertThat(foundFireStation.getAddress()).isEqualToIgnoringCase(fireStation.getAddress());
    }
   
}
