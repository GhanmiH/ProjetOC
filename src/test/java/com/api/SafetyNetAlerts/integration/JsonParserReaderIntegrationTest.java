package com.api.SafetyNetAlerts.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.SafetyNetAlerts.service.FireStationService;
import com.api.SafetyNetAlerts.service.MedicalRecordService;
import com.api.SafetyNetAlerts.service.PersonService;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JsonParserReaderIntegrationTest {

	@Autowired
    private PersonService personService;

    @Autowired
    private FireStationService fireStationService;

    @Autowired
    private MedicalRecordService medicalRecordService;
    
    @Test
    public void CheckLoadedDataPeronFromJsonFile() {
        assertThat(personService.getAllPersons()).size().isEqualTo(23);
    }

    @Test
    public void CheckLoadedDataFireStationFromJsonFile() {
        assertThat(fireStationService.getFireStations()).size().isEqualTo(13);
    }

    @Test
    public void CheckLoadedDataMedicalRecordFromJsonFile() {
        assertThat(medicalRecordService.getAllMedicalRecords()).size().isEqualTo(23);
    }
}
