package com.project.powertransformer.service;


import com.project.powertransformerservice.calculation.TransformerSelectionCalculation;
import com.project.powertransformerservice.entity.TransformerSelection;
import com.project.powertransformerservice.repository.PowerTransformerRepository;
import com.project.powertransformerservice.repository.TransformerSelectionRepository;
import com.project.powertransformerservice.rest.FullInformationServiceClient;
import com.project.powertransformerservice.service.PowerTransformersService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PowerTransformersServiceTest {
    @Mock
    private  FullInformationServiceClient fullInformationServiceClient;
    @Mock
    private  TransformerSelectionRepository transformerSelectionRepository;
    @Mock
    private  PowerTransformerRepository powerTransformerRepository;
    @InjectMocks
    private PowerTransformersService powerTransformersService;

    @Test
    public void powerTransformersService_createPowerTransformerSelectionInformation(){

        TransformerSelectionCalculation transformerSelectionCalculation = new TransformerSelectionCalculation();

        TransformerSelection powerTransformerSelectionInformation = transformerSelectionCalculation
                .createPowerTransformerSelectionInformation((short) 1, 565.8F);

        Assertions.assertEquals(132.17F,powerTransformerSelectionInformation.getRatedPowerForTransformerSelection());
    }


}
