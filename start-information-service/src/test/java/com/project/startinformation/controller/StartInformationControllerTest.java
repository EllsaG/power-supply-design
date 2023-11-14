package com.project.startinformation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.startinformation.config.SpringH2DatabaseConfig;
import com.project.startinformationservice.StartInformationApplication;
import com.project.startinformationservice.controller.dto.StartInformationRequestDTO;
import com.project.startinformationservice.controller.dto.StartInformationResponseDTO;
import com.project.startinformationservice.entity.StartInformation;
import com.project.startinformationservice.repository.StartInformationRepository;
import com.project.startinformationservice.rest.ProtectiveEquipmentServiceClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StartInformationApplication.class, SpringH2DatabaseConfig.class})
public class StartInformationControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private StartInformationRepository startInformationRepository;

    @MockBean
    private ProtectiveEquipmentServiceClient protectiveEquipmentServiceClient;
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void saveStartInformation() throws Exception {

        String REQUEST = createRequestAsString();

        MvcResult mvcResult = mockMvc.perform(put("/create")
                        .content(REQUEST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status()
                        .isOk())
                .andReturn();
        String body = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        Optional<StartInformation> byId = startInformationRepository.findById((short) 1);
        ObjectMapper objectMapper = new ObjectMapper();
        StartInformationResponseDTO startInformationResponseDTO = objectMapper.readValue(body, StartInformationResponseDTO.class);
        StartInformation startInformation = startInformationResponseDTO.getStartInformationList().get(0);


        Assertions.assertEquals(byId.get().getAvgDailyActivePower(),  startInformation.getAvgDailyActivePower());
        Assertions.assertEquals(byId.get().getAvgDailyReactivePower(),  startInformation.getAvgDailyReactivePower());
    }



    @Test
    public void protectiveEquipmentServiceClient_checkAvailability() {
        Mockito.when(protectiveEquipmentServiceClient.checkAvailability(ArgumentMatchers.anyShort())).thenReturn(false);
    }


    private String createRequestAsString() throws JsonProcessingException {
        StartInformationRequestDTO startInformationRequestDTO = new StartInformationRequestDTO((short) 1,
                "Станок вертикально-сверлильный", 17.5F, (short) 5, 0.16F, 0.5F, 1.73F);
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(startInformationRequestDTO);

    }




}
