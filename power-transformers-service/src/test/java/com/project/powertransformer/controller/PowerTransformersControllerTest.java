package com.project.powertransformer.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.powertransformer.config.SpringH2DatabaseConfig;
import com.project.powertransformerservice.PowerTransformerApplication;
import com.project.powertransformerservice.controller.dto.PowerTransformerSelectionInformationRequestDTO;
import com.project.powertransformerservice.controller.dto.PowerTransformersRequestDTO;
import com.project.powertransformerservice.controller.dto.PowerTransformersResponseDTO;
import com.project.powertransformerservice.entity.PowerTransformers;
import com.project.powertransformerservice.entity.TransformerSelection;
import com.project.powertransformerservice.repository.PowerTransformerRepository;
import com.project.powertransformerservice.repository.TransformerSelectionRepository;
import com.project.powertransformerservice.rest.FullInformationResponseDTO;
import com.project.powertransformerservice.rest.FullInformationServiceClient;
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
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.NoSuchElementException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PowerTransformerApplication.class, SpringH2DatabaseConfig.class})
public class PowerTransformersControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private TransformerSelectionRepository transformerSelectionRepository;

    @Autowired
    private PowerTransformerRepository powerTransformerRepository;

    @MockBean
    private FullInformationServiceClient fullInformationServiceClient;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Sql(scripts = {"/sql/clearPowerTransformerSelectionInformationDB.sql"})
    public void createPowerTransformerSelectionInformation() throws Exception {

        String REQUEST = createPowerTransformerSelectionInformationRequestAsString();

        mockMvc.perform(put("/create/selectionInformation")
                        .content(REQUEST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status()
                        .isOk())
                .andReturn();

        TransformerSelection transformerSelection = transformerSelectionRepository.findById((short) 3)
                .orElseThrow(() -> new NoSuchElementException("No value present"));

        Assertions.assertEquals(132.17F, transformerSelection.getRatedPowerForTransformerSelection());
    }

    @Test
    @Sql(scripts = {"/sql/clearPowerTransformerSelectionInformationDB.sql", "/sql/addPowerTransformerSelectionInformation.sql"})
    public void createPowerTransformer() throws Exception {

        Mockito.when(fullInformationServiceClient.getFullInformationById(ArgumentMatchers.anyShort())).thenReturn(createFullInformationResponseDTO());

        String REQUEST = createPowerTransformersRequestAsString();

        MvcResult mvcResult = mockMvc.perform(put("/create/powerTransformer")
                        .content(REQUEST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status()
                        .isOk())
                .andReturn();

        String body = mvcResult.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();

        PowerTransformersResponseDTO powerTransformersResponseDTO = objectMapper.readValue(body, PowerTransformersResponseDTO.class);
        PowerTransformers powerTransformers = powerTransformersResponseDTO.getPowerTransformersList().get(0);

        PowerTransformers powerTransformersById = powerTransformerRepository.findById((short) 3)
                .orElseThrow(() -> new NoSuchElementException("No value present"));

        Assertions.assertEquals(powerTransformers.getTransformerModel(), powerTransformersById.getTransformerModel());
        Assertions.assertEquals(powerTransformers.getTransformerFullPower(), powerTransformersById.getTransformerFullPower());
        Assertions.assertEquals(powerTransformers.getTransformerLoadCoef(), powerTransformersById.getTransformerLoadCoef());
        Assertions.assertEquals(powerTransformers.getShortCircuitVoltage(), powerTransformersById.getShortCircuitVoltage());
        Assertions.assertEquals(powerTransformers.getTransformerIdleLosses(), powerTransformersById.getTransformerIdleLosses());
        Assertions.assertEquals(powerTransformers.getHighSideVoltage(), powerTransformersById.getHighSideVoltage());
        Assertions.assertEquals(powerTransformers.getLowSideVoltage(), powerTransformersById.getLowSideVoltage());
        Assertions.assertEquals(powerTransformers.getShortCircuitLosses(), powerTransformersById.getShortCircuitLosses());
        Assertions.assertEquals(powerTransformers.getIdleCurrent(), powerTransformersById.getIdleCurrent());
    }


    private FullInformationResponseDTO createFullInformationResponseDTO() {
        return new FullInformationResponseDTO((short) 3, "ШМА-1", (short) 3, 0.94F,
                1.09F, (short) 3, 3.23F, 3.04F, 1.09F, 3.23F,
                4.91F, 16.5F, 0.65F, 1.16F, 0.06F, 1);
    }

    private String createPowerTransformersRequestAsString() throws JsonProcessingException {
        PowerTransformersRequestDTO request =
                new PowerTransformersRequestDTO((short) 3, "TMG-1000", 250.0F,
                        5.5F, 1400.0F, 10.0F, 0.4F,
                        10.5F, 0.5F);

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(request);
    }

    private String createPowerTransformerSelectionInformationRequestAsString() throws JsonProcessingException {
        PowerTransformerSelectionInformationRequestDTO request =
                new PowerTransformerSelectionInformationRequestDTO((short) 3, 565.8F);

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(request);
    }


}
