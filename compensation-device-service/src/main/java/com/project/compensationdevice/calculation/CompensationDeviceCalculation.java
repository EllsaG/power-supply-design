package com.project.compensationdevice.calculation;


import com.project.compensationdevice.entity.CompensationDevice;
import com.project.compensationdevice.entity.CompensationDeviceSelection;
import com.project.compensationdevice.exceptions.IncorrectNumberValueException;
import com.project.compensationdevice.repository.CompensationDeviceSelectionRepository;
import com.project.compensationdevice.rest.FullInformationResponseDTO;

import java.util.NoSuchElementException;

public class CompensationDeviceCalculation {
    private static final float coefTakingIncreasingCosF = 0.9F;

    public CompensationDeviceSelection createCompensationDeviceSelectionInformation(short compensationDeviceId, float avgDailyActivePower, float tgfBeforeCompensation) {
        float minTgfRecommendedAfterCompensation = 0.33F;
        float maxTgfRecommendedAfterCompensation = 0.4F;

        float maxPowerOfCompensatingDevice =  (Math.round(avgDailyActivePower * coefTakingIncreasingCosF
                        * (tgfBeforeCompensation - minTgfRecommendedAfterCompensation) * 100.0) / 100.0F);
        float  minPowerOfCompensatingDevice= (Math.round(avgDailyActivePower * coefTakingIncreasingCosF
                        * (tgfBeforeCompensation - maxTgfRecommendedAfterCompensation) * 100.0) / 100.0F);

        return new CompensationDeviceSelection(compensationDeviceId, minPowerOfCompensatingDevice, maxPowerOfCompensatingDevice);
    }

    public CompensationDevice createNewCompensatingDevice(short compensationDeviceId, String nameOfCompensationDevice, float powerOfCompensatingDevice,
                                                          FullInformationResponseDTO fullInformation,
                                                          CompensationDeviceSelectionRepository compensationDeviceSelectionRepository) {


        float avgDailyActivePower = fullInformation.getFullInformation().getAvgDailyActivePower();
        float tgfBeforeCompensation = fullInformation.getFullInformation().getTgF();

        float tgfActualValueCheck = (tgfBeforeCompensation - powerOfCompensatingDevice
                        / (coefTakingIncreasingCosF * avgDailyActivePower));

        if (tgfActualValueCheck >=0.33 && tgfActualValueCheck <= 0.4){
            return new CompensationDevice(compensationDeviceId, nameOfCompensationDevice, powerOfCompensatingDevice);
        }else {
            CompensationDeviceSelection compensationDeviceSelection = compensationDeviceSelectionRepository.findById(compensationDeviceId)
                    .orElseThrow(() -> new NoSuchElementException("No value present"));
            float minPowerOfCompensatingDevice = compensationDeviceSelection.getMinPowerOfCompensatingDevice();
            float maxPowerOfCompensatingDevice = compensationDeviceSelection.getMaxPowerOfCompensatingDevice();
            throw new IncorrectNumberValueException("Incorrect power value of the compensating device, as it should be between "
                    + minPowerOfCompensatingDevice + " and " + maxPowerOfCompensatingDevice);
        }
    }
}
