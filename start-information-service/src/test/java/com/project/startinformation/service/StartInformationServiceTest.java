package com.project.startinformation.service;

import com.project.startinformationservice.calculation.StartInformationCalculation;
import com.project.startinformationservice.entity.StartInformation;
import com.project.startinformationservice.exceptions.InformationNotFoundException;
import com.project.startinformationservice.repository.StartInformationRepository;
import com.project.startinformationservice.service.StartInformationService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class StartInformationServiceTest {
    @Mock
    StartInformationRepository startInformationRepository;
    @InjectMocks
    StartInformationService startInformationService;


    @Test
    public void startInformationServiceTest_isAvailable() {
        Mockito.when(startInformationService.isAvailable(ArgumentMatchers.anyShort())).thenReturn(ArgumentMatchers.anyBoolean());
    }

    @Test
    public void startInformationServiceTest_saveStartInformation() {

        StartInformationCalculation startInformationCalculation = new StartInformationCalculation();
        StartInformation startInformation = startInformationCalculation
                .createIfDontExist(startInformationRepository, (short) 1,
                        "Станок вертикально сверлильный", 17.5F, (short) 5, 0.16F, 0.5F, 1.73F);

        Assertions.assertEquals(2.8F,  startInformation.getAvgDailyActivePower());
        Assertions.assertEquals(4.84F,  startInformation.getAvgDailyReactivePower());
    }


    @Test(expected = InformationNotFoundException.class)
    public void startInformationServiceTest_getStartInformationByIdList_exception() {
        List<Short> shortList = new ArrayList<>();
        shortList.add((short) 1);
        shortList.add((short) 2);
        startInformationService.getStartInformationByIdList(shortList);
    }






}



