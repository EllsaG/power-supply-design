package com.project.protectiveequipment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.protectiveequipment.config.SpringH2DatabaseConfig;
import com.project.protectiveequipmentservice.ProtectiveEquipmentApplication;
import com.project.protectiveequipmentservice.controller.dto.ProtectiveEquipmentRequestDTO;
import com.project.protectiveequipmentservice.controller.dto.ProtectiveEquipmentResponseDTO;
import com.project.protectiveequipmentservice.controller.dto.ProtectiveEquipmentSelectionInformationRequestDTO;
import com.project.protectiveequipmentservice.entity.ProtectiveEquipment;
import com.project.protectiveequipmentservice.entity.ProtectiveEquipmentSelection;
import com.project.protectiveequipmentservice.repository.ProtectiveEquipmentRepository;
import com.project.protectiveequipmentservice.repository.ProtectiveEquipmentSelectionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ProtectiveEquipmentApplication.class, SpringH2DatabaseConfig.class})
public class ProtectiveEquipmentControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ProtectiveEquipmentRepository protectiveEquipmentRepository;

    @Autowired
    private ProtectiveEquipmentSelectionRepository protectiveEquipmentSelectionRepository;


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    @Sql(scripts = {"/sql/clearProtectiveEquipmentSelectionDB.sql", "/sql/addProtectiveEquipmentSelectionInformation.sql"})
    public void createProtectiveEquipment() throws Exception {

        String REQUEST = createProtectiveEquipmentRequestAsString();

        MvcResult mvcResult = mockMvc.perform(put("/create/protectiveEquipment")
                        .content(REQUEST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status()
                        .isOk())
                .andReturn();

        ProtectiveEquipment byId = protectiveEquipmentRepository.findById((short) 1).orElseThrow(() -> new NoSuchElementException("No value present"));
        String body = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();
        ProtectiveEquipmentResponseDTO protectiveEquipmentResponseDTO = objectMapper
                .readValue(body, ProtectiveEquipmentResponseDTO.class);
        ProtectiveEquipment protectiveEquipment = protectiveEquipmentResponseDTO.getProtectiveEquipmentList().get(0);

        Assertions.assertEquals(byId.getElectromagneticReleaseRatedCurrent(), protectiveEquipment.getElectromagneticReleaseRatedCurrent());
        Assertions.assertEquals(byId.getThermalReleaseRatedCurrent(), protectiveEquipment.getThermalReleaseRatedCurrent());
        Assertions.assertEquals(byId.getCircuitBreakerRatedCurrent(), protectiveEquipment.getCircuitBreakerRatedCurrent());
        Assertions.assertEquals(byId.getCircuitBreakerType(), protectiveEquipment.getCircuitBreakerType());
        Assertions.assertEquals(byId.getLow_volt_cables_id_fk().getCableType(),
                protectiveEquipment.getLow_volt_cables_id_fk().getCableType());

    }


    @Test
    public void createProtectiveEquipmentSelectionInformation() throws Exception {

        String REQUEST = createProtectiveEquipmentSelectionInformationRequestAsString();

        mockMvc.perform(put("/create/selectionInformation")
                        .content(REQUEST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status()
                        .isOk())
                .andReturn();

        ProtectiveEquipmentSelection byId = protectiveEquipmentSelectionRepository.findById((short) 1).orElseThrow(() -> new NoSuchElementException("No value present"));

        Assertions.assertEquals(305.6F, byId.getEquipmentStartingCurrent());
        Assertions.assertEquals(61.12F, byId.getEquipmentRatedCurrent());
        Assertions.assertEquals(70.29F, byId.getCalculatedCurrentOfThermalRelease());
        Assertions.assertEquals(382F, byId.getCalculatedCurrentOfElectromagneticRelease());

    }



    private String createProtectiveEquipmentSelectionInformationRequestAsString() throws JsonProcessingException {
        ProtectiveEquipmentSelectionInformationRequestDTO protectiveEquipmentSelectionInformationRequestDTO =
                new ProtectiveEquipmentSelectionInformationRequestDTO((short) 1, 17.5F, 0.5F);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(protectiveEquipmentSelectionInformationRequestDTO);

    }

    private String createProtectiveEquipmentRequestAsString() throws JsonProcessingException {
        ProtectiveEquipmentRequestDTO protectiveEquipmentRequestDTO =
                new ProtectiveEquipmentRequestDTO(
                        (short) 1, "ВА 47-100", 80.0F,
                        800.0F, 80.0F, "ВВГ 4х16");

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(protectiveEquipmentRequestDTO);

    }


}
