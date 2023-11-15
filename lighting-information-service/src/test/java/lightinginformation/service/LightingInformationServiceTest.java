package lightinginformation.service;


import com.project.lightinginformationservice.calculation.LightingCalculation;
import com.project.lightinginformationservice.entity.LuminaireSelection;
import com.project.lightinginformationservice.repository.LightingInformationRepository;
import com.project.lightinginformationservice.repository.LuminaireSelectionRepository;
import com.project.lightinginformationservice.service.LightingInformationService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LightingInformationServiceTest {
    @Mock
    LightingInformationRepository lightingInformationRepository;
    @Mock
    LuminaireSelectionRepository luminaireSelectionRepository;
    @InjectMocks
    LightingInformationService lightingInformationService;



    @Test
    public void lightingInformationServiceTest_saveLuminaireSelectionInformation() {

        LightingCalculation lightingCalculation = new LightingCalculation();
        LuminaireSelection luminaireSelection = lightingCalculation.lightingCalculation((short) 1,
                6, 36, 72, luminaireSelectionRepository);

        Assertions.assertEquals(4,  luminaireSelection.getDistanceBetweenLampRows());
        Assertions.assertEquals(1,  luminaireSelection.getDistanceBetweenWallAndFirstLampRow());
        Assertions.assertEquals(18,  luminaireSelection.getAmountLuminairesPerLength());
        Assertions.assertEquals(9,  luminaireSelection.getAmountLuminairesPerWidth());
        Assertions.assertEquals(10350,  luminaireSelection.getLightFlux());
        Assertions.assertEquals(6,  luminaireSelection.getProductionHallHeight());
        Assertions.assertEquals(36,  luminaireSelection.getProductionHallWidth());
        Assertions.assertEquals(72,  luminaireSelection.getProductionHallLength());

    }


}



