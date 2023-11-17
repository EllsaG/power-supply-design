package com.project.compensationdevice.service;

import com.project.compensationdevice.calculation.CompensationDeviceCalculation;
import com.project.compensationdevice.entity.CompensationDevice;
import com.project.compensationdevice.entity.CompensationDeviceSelection;
import com.project.compensationdevice.repository.CompensationDeviceRepository;
import com.project.compensationdevice.repository.CompensationDeviceSelectionRepository;
import com.project.compensationdevice.rest.FullInformation;
import com.project.compensationdevice.rest.FullInformationResponseDTO;
import com.project.compensationdevice.rest.FullInformationServiceClient;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.NoSuchElementException;

@RunWith(MockitoJUnitRunner.class)
public class CompensationDeviceServiceTest {

    @Mock
    private FullInformationServiceClient fullInformationServiceClient;
    @Mock
    private CompensationDeviceRepository compensationDeviceRepository;
    @Mock
    private CompensationDeviceSelectionRepository compensationDeviceSelectionRepository;

    @InjectMocks
    private CompensationDeviceService compensationDeviceService;


    @Test
    public void compensationDeviceService_saveCompensationDeviceSelectionInformation() {

        CompensationDeviceCalculation compensationDeviceCalculation = new CompensationDeviceCalculation();
        CompensationDeviceSelection compensationDeviceSelectionInformation = compensationDeviceCalculation
                .createCompensationDeviceSelectionInformation((short) 3, 0.94F, 1.16F);

        Assertions.assertEquals(0.64F, compensationDeviceSelectionInformation.getMinPowerOfCompensatingDevice());
        Assertions.assertEquals(0.7F, compensationDeviceSelectionInformation.getMaxPowerOfCompensatingDevice());
    }


    @Test
    public void compensationDeviceService_saveCompensationDevice() {

        CompensationDeviceCalculation compensationDeviceCalculation = new CompensationDeviceCalculation();
        CompensationDevice compensationDevice = compensationDeviceCalculation.createNewCompensatingDevice((short) 3, "KRM",
                0.65F, createFullInformationResponseDTO(), compensationDeviceSelectionRepository);


        Assertions.assertEquals("KRM", compensationDevice.getModelOfCompensationDevice());
        Assertions.assertEquals(0.65F, compensationDevice.getReactivePowerOfCompensationDevice());

    }

    @Test(expected = NoSuchElementException.class)
    public void compensationDeviceService_saveCompensationDevice_exception() {
        FullInformationResponseDTO fullInformationResponseDTO = createFullInformationResponseDTO();
        CompensationDeviceCalculation compensationDeviceCalculation = new CompensationDeviceCalculation();
        compensationDeviceCalculation.createNewCompensatingDevice((short) 3, "KRM",
                10.65F, fullInformationResponseDTO, compensationDeviceSelectionRepository);
    }


    private FullInformationResponseDTO createFullInformationResponseDTO() {
        return new FullInformationResponseDTO(new FullInformation((short) 3, "ШМА-1", (short) 3, 0.94F,
                1.09F, (short) 3, 3.23F, 3.04F, 1.09F, 3.23F,
                4.91F, 16.5F, 0.65F, 1.16F, 0.06F, 1));
    }

}