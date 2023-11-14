package com.project.protectiveequipment.service;

import com.project.protectiveequipmentservice.calculation.ProtectiveEquipmentCalculation;
import com.project.protectiveequipmentservice.entity.ProtectiveEquipmentSelection;
import com.project.protectiveequipmentservice.repository.ProtectiveEquipmentRepository;
import com.project.protectiveequipmentservice.service.ProtectiveEquipmentService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProtectiveEquipmentServiceTest {
    @Mock
    ProtectiveEquipmentRepository protectiveEquipmentRepository;
    @InjectMocks
    ProtectiveEquipmentService protectiveEquipmentService;


    @Test
    public void protectiveEquipmentServiceTest_isAvailable() {
        Mockito.when(protectiveEquipmentService.isAvailable(ArgumentMatchers.anyShort())).thenReturn(ArgumentMatchers.anyBoolean());
    }

    @Test
    public void protectiveEquipmentServiceTest_createNewProtectiveEquipmentSelectionInformation() {

        ProtectiveEquipmentCalculation protectiveEquipmentCalculation = new ProtectiveEquipmentCalculation();
        ProtectiveEquipmentSelection newProtectiveEquipmentSelectionInformation = protectiveEquipmentCalculation
                .createNewProtectiveEquipmentSelectionInformation((short) 1, 17.5F, 0.5F);

        Assertions.assertEquals(305.6F,  newProtectiveEquipmentSelectionInformation.getEquipmentStartingCurrent());
        Assertions.assertEquals(61.12F,  newProtectiveEquipmentSelectionInformation.getEquipmentRatedCurrent());
        Assertions.assertEquals(70.29F,  newProtectiveEquipmentSelectionInformation.getCalculatedCurrentOfThermalRelease());
        Assertions.assertEquals(382F,  newProtectiveEquipmentSelectionInformation.getCalculatedCurrentOfElectromagneticRelease());
    }

}



