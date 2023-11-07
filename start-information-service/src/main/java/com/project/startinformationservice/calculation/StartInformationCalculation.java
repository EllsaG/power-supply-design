package com.project.startinformationservice.calculation;


import com.project.startinformationservice.entity.StartInformation;
import com.project.startinformationservice.exceptions.InformationAlreadyExistsException;
import com.project.startinformationservice.repository.StartInformationRepository;

import java.util.List;
import java.util.Optional;

public class StartInformationCalculation {

    public StartInformation createIfDontExist(StartInformationRepository startInformationRepository, short startInformId,
                                              String name, float activePower, short amount, float ki, float cosf, float tgf) {

        Optional<StartInformation> byId = startInformationRepository.findById(startInformId);
        if (byId.isPresent()) {
            throw new InformationAlreadyExistsException("Information about equipment with id № " + startInformId + " is already exists");
        }

        List<StartInformation> all = startInformationRepository.findAll();

        for (StartInformation startInformation : all) {
            if (startInformation.getName().equals(name) && startInformation.getActivePower() == activePower) {
                throw new InformationAlreadyExistsException("Information about equipment with name: " + name + " and power: " + activePower + " is already exists");
            }
        }

        float avgDailyActivePower = Math.round(activePower * ki * 100.0) / 100.0F; // average daily active power of one equipment
        float avgDailyReactivePower = Math.round(avgDailyActivePower * tgf * 100.0) / 100.0F; // average daily reactive power of one equipment


        return new StartInformation(startInformId, name, activePower, amount, ki, cosf, tgf, avgDailyActivePower, avgDailyReactivePower);

    }
}