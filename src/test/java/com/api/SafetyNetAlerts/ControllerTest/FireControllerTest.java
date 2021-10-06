package com.api.SafetyNetAlerts.ControllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import com.api.SafetyNetAlerts.model.FireList;
import com.api.SafetyNetAlerts.service.FireService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FireControllerTest {

	@Autowired
    MockMvc mockMvc;
    @MockBean
    FireService fireService;

    @Test
    public void testGetPeopleWhenFire() throws Exception {
        when(fireService.getPeopleWhenFire(anyString())).thenReturn(any(FireList.class));
        mockMvc.perform(get("/fire?address=a"))
                .andExpect(status().isOk());
    }
}
