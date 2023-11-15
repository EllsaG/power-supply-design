package lightinginformation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.lightinginformationservice.LightingInformationApplication;
import com.project.lightinginformationservice.controller.dto.*;
import com.project.lightinginformationservice.entity.LightInformation;
import com.project.lightinginformationservice.entity.LuminaireSelection;
import com.project.lightinginformationservice.repository.LightingInformationRepository;
import com.project.lightinginformationservice.repository.LuminaireSelectionRepository;
import lightinginformation.config.SpringH2DatabaseConfig;
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
@SpringBootTest(classes = {LightingInformationApplication.class, SpringH2DatabaseConfig.class})
public class LightingInformationControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private LuminaireSelectionRepository luminaireSelectionRepository;

    @Autowired
    private LightingInformationRepository lightingInformationRepository;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    @Sql(scripts = {"/sql/clearLuminaireSelectionDB.sql"})
    public void saveLuminaireSelectionInformation() throws Exception {

        String REQUEST = createLuminaireSelectionRequestAsString();

        MvcResult mvcResult = mockMvc.perform(put("/create/selectionInformation")
                        .content(REQUEST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status()
                        .isOk())
                .andReturn();

        LuminaireSelection luminaireSelection = luminaireSelectionRepository.findById((short) 1)
                .orElseThrow(() -> new NoSuchElementException("No value present"));

        String body = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();
        LuminaireSelectionResponseDTO luminaireSelectionResponseDTO = objectMapper
                .readValue(body, LuminaireSelectionResponseDTO.class);

        Assertions.assertEquals(4, luminaireSelection.getDistanceBetweenLampRows());
        Assertions.assertEquals(1, luminaireSelection.getDistanceBetweenWallAndFirstLampRow());
        Assertions.assertEquals(18, luminaireSelection.getAmountLuminairesPerLength());
        Assertions.assertEquals(9, luminaireSelection.getAmountLuminairesPerWidth());
        Assertions.assertEquals(10350, luminaireSelection.getLightFlux());
        Assertions.assertEquals(6, luminaireSelection.getProductionHallHeight());
        Assertions.assertEquals(36, luminaireSelection.getProductionHallWidth());
        Assertions.assertEquals(72, luminaireSelection.getProductionHallLength());


        LightFluxAtAmountOfLamps lightFluxWithOneLampInLuminaire = luminaireSelectionResponseDTO.getLightFluxAtAmountOfLampsList().get(0);
        LightFluxAtAmountOfLamps lightFluxWithTwoLampsInLuminaire = luminaireSelectionResponseDTO.getLightFluxAtAmountOfLampsList().get(1);
        LightFluxAtAmountOfLamps lightFluxWithThreeLampsInLuminaire = luminaireSelectionResponseDTO.getLightFluxAtAmountOfLampsList().get(2);
        LightFluxAtAmountOfLamps lightFluxWithFourLampsInLuminaire = luminaireSelectionResponseDTO.getLightFluxAtAmountOfLampsList().get(3);

        Assertions.assertEquals(1, lightFluxWithOneLampInLuminaire.getAmountOfLampsInOneLuminaire());
        Assertions.assertEquals(14490.0F, lightFluxWithOneLampInLuminaire.getMinLightFluxForLuminaireSelection());
        Assertions.assertEquals(16560.0F, lightFluxWithOneLampInLuminaire.getMaxLightFluxForLuminaireSelection());

        Assertions.assertEquals(2, lightFluxWithTwoLampsInLuminaire.getAmountOfLampsInOneLuminaire());
        Assertions.assertEquals(7245.0F, lightFluxWithTwoLampsInLuminaire.getMinLightFluxForLuminaireSelection());
        Assertions.assertEquals(8280.0F, lightFluxWithTwoLampsInLuminaire.getMaxLightFluxForLuminaireSelection());

        Assertions.assertEquals(3, lightFluxWithThreeLampsInLuminaire.getAmountOfLampsInOneLuminaire());
        Assertions.assertEquals(4830.0F, lightFluxWithThreeLampsInLuminaire.getMinLightFluxForLuminaireSelection());
        Assertions.assertEquals(5520.0F, lightFluxWithThreeLampsInLuminaire.getMaxLightFluxForLuminaireSelection());

        Assertions.assertEquals(4, lightFluxWithFourLampsInLuminaire.getAmountOfLampsInOneLuminaire());
        Assertions.assertEquals(3622.5F, lightFluxWithFourLampsInLuminaire.getMinLightFluxForLuminaireSelection());
        Assertions.assertEquals(4140.0F, lightFluxWithFourLampsInLuminaire.getMaxLightFluxForLuminaireSelection());

    }

    @Test
    @Sql(scripts = {"/sql/addLuminaireSelectionInformation.sql"})
    public void saveLightingInformation() throws Exception {

        String REQUEST = createLightingInformationRequestAsString();

        MvcResult mvcResult = mockMvc.perform(put("/create/lighting")
                        .content(REQUEST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status()
                        .isOk())
                .andReturn();

        LightInformation lightInformationById = lightingInformationRepository.findById((short) 1)
                .orElseThrow(() -> new NoSuchElementException("No value present"));

        String body = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();
        LightingInformationResponseDTO lightingInformationResponseDTO = objectMapper
                .readValue(body, LightingInformationResponseDTO.class);
        LightInformation lightInformation = lightingInformationResponseDTO.getLightInformationList().get(0);

        Assertions.assertEquals(lightInformationById.getLampModel(), lightInformation.getLampModel());
        Assertions.assertEquals(lightInformationById.getAmountLuminaires(), lightInformation.getAmountLuminaires());
        Assertions.assertEquals(lightInformationById.getAmountLampsInOneLuminaire(), lightInformation.getAmountLampsInOneLuminaire());
        Assertions.assertEquals(lightInformationById.getOneLampPower(), lightInformation.getOneLampPower());
        Assertions.assertEquals(lightInformationById.getOneLampLightFlux(), lightInformation.getOneLampLightFlux());
        Assertions.assertEquals(lightInformationById.getDistanceBetweenLampRows(), lightInformation.getDistanceBetweenLampRows());
        Assertions.assertEquals(lightInformationById.getDistanceBetweenWallAndFirstLampRow(), lightInformation.getDistanceBetweenWallAndFirstLampRow());
        Assertions.assertEquals(lightInformationById.getAmountLuminairesPerLength(), lightInformation.getAmountLuminairesPerLength());
        Assertions.assertEquals(lightInformationById.getAmountLuminairesPerWidth(), lightInformation.getAmountLuminairesPerWidth());
        Assertions.assertEquals(lightInformationById.getTotalActivePower(), lightInformation.getTotalActivePower());
        Assertions.assertEquals(lightInformationById.getTotalReactivePower(), lightInformation.getTotalReactivePower());
        Assertions.assertEquals(lightInformationById.getTotalFullPower(), lightInformation.getTotalFullPower());
        Assertions.assertEquals(lightInformationById.getElectricCurrent(), lightInformation.getElectricCurrent());
        Assertions.assertEquals(lightInformationById.getElectricCurrentOfOneRowOfLuminaires(), lightInformation.getElectricCurrentOfOneRowOfLuminaires());
        Assertions.assertEquals(lightInformationById.getCosF(), lightInformation.getCosF());
        Assertions.assertEquals(lightInformationById.getTgF(), lightInformation.getTgF());
    }


    private String createLuminaireSelectionRequestAsString() throws JsonProcessingException {
        LuminaireSelectionRequestDTO luminaireSelectionRequestDTO =
                new LuminaireSelectionRequestDTO((short) 1, 6, 36, 72);
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(luminaireSelectionRequestDTO);
    }


    private String createLightingInformationRequestAsString() throws JsonProcessingException {
        LightingInformationRequestDTO lightingInformationRequestDTO =
                new LightingInformationRequestDTO((short) 1, "ЛСП68-2х80-011 HF IP65",
                        "FT5/80W/830/24000HRS/GE/SL1/30", (short) 2, 7000, 80);
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(lightingInformationRequestDTO);
    }

}