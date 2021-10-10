package com.api.SafetyNetAlerts.ServiceTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;
import com.api.SafetyNetAlerts.model.FireStation;
import com.api.SafetyNetAlerts.repository.FireStationRepository;
import com.api.SafetyNetAlerts.service.FireStationService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


@SpringBootTest
//@AutoConfigureMockMvc
class FirestationServiceTest {

	 @MockBean
	    FireStationRepository firestationRepository;
	    @Autowired
	    FireStationService firestationService;

	    private FireStation f1;
	    private FireStation f2;
	    private List<FireStation> firestationList;

	    @BeforeAll
	    public static void initAll(){

	    }

	    @BeforeEach
	    public void initEach(){
	        f1 = new FireStation();
	        f2 = new FireStation();
	        f1.setStation("1");
	        f1.setAddress("rue de Paris");
	        f2.setStation("2");
	        f2.setAddress("rue de Lille");
	        firestationList = new ArrayList<>();
	        firestationList.add(f1);
	        firestationList.add(f2);
	    }
	    
	    @Test
	    public void getFirestationFromAddress_ShouldUseFirestationRepository () {
	        /*when(firestationRepository.findByAddress(any(String.class))).thenReturn(any(Optional.class));
	        firestationService.getFirestationFromAddress(any(String.class));
	        verify(firestationRepository, times(1)).findByAddress(any(String.class));*/

	        when(firestationRepository.findAllByAddress("abc")).thenReturn(firestationList);
	        firestationService.getFirestationFromAddress("abc");
	        verify(firestationRepository, times(1)).findAllByAddress("abc");

	    }

	    @Test
	    public void getFirestationsFromStationNumber_ShouldUseFirestationRepository () {
	        when(firestationRepository.findAllByStation("1")).thenReturn(firestationList);
	        firestationService.getFirestationsFromStationNumber("1");
	        verify(firestationRepository, times(1)).findAllByStation("1");
	    }


	    @Test
	    public void removeFirestationByAddress_ShouldUseFirestationRepository() {
	        firestationService.deleteFirestationByAddress(anyString());
	        verify(firestationRepository, times(1)).deleteByAddress(anyString());
	    }
	    
	}
