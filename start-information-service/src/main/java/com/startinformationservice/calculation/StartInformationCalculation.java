package com.startinformationservice.calculation;


import com.startinformationservice.entity.StartInformation;
import com.startinformationservice.exceptions.InformationAlreadyExistsException;
import com.startinformationservice.repository.StartInformationRepository;

import java.util.List;
import java.util.Optional;

public class StartInformationCalculation {

    public StartInformation createIfDontExist(StartInformationRepository startInformationRepository, short startInformId,
                                              String name, float power, short amount, float ki, float cosf, float tgf) {

        Optional<StartInformation> byId = startInformationRepository.findById(startInformId);
        if (byId.isPresent()) {
            throw new InformationAlreadyExistsException("Information about equipment with id № " + startInformId + " is already exists");
        }

        List<StartInformation> all = startInformationRepository.findAll();

        for (StartInformation startInformation : all) {
            if (startInformation.getName().equals(name) && startInformation.getPower() == power) {
                throw new InformationAlreadyExistsException("Information about equipment with name: " + name + " and power: " + power + " is already exists");
            }
        }

        float avgDailyActivePower = (float) (Math.round(power * ki * 100.0) / 100.0); // average daily active power of one equipment
        float avgDailyReactivePower = (float) (Math.round(avgDailyActivePower * tgf * 100.0) / 100.0); // average daily reactive power of one equipment


        return new StartInformation(startInformId, name, power, amount, ki, cosf, tgf, avgDailyActivePower, avgDailyReactivePower);

    }
}
