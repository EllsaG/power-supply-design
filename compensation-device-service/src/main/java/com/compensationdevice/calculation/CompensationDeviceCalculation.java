package com.compensationdevice.calculation;


import com.compensationdevice.entity.CompensationDevice;
import com.compensationdevice.entity.CompensationDeviceSelection;
import com.compensationdevice.exceptions.IncorrectNumberValueException;
import com.compensationdevice.repository.CompensationDeviceSelectionRepository;
import com.compensationdevice.rest.FullInformationResponseDTO;

public class CompensationDeviceCalculation {
    private static final float coefTakingIncreasingCosf = 0.9F;

    public CompensationDeviceSelection createCompensationDeviceSelectionInformation(short compensationDeviceId, float avgDailyActivePower, float tgfBeforeCompensation) {
        float minTgfRecommendedAfterCompensation = 0.33F;
        float maxTgfRecommendedAfterCompensation = 0.4F;

        float maxPowerOfCompensatingDevice =  (Math.round(avgDailyActivePower * coefTakingIncreasingCosf
                        * (tgfBeforeCompensation - minTgfRecommendedAfterCompensation) * 100.0) / 100.0F);
        float  minPowerOfCompensatingDevice= (Math.round(avgDailyActivePower * coefTakingIncreasingCosf
                        * (tgfBeforeCompensation - maxTgfRecommendedAfterCompensation) * 100.0) / 100.0F);

        return new CompensationDeviceSelection(compensationDeviceId, minPowerOfCompensatingDevice, maxPowerOfCompensatingDevice);
    }

    public CompensationDevice createNewCompensatingDevice(short compensationDeviceId, String nameOfCompensationDevice, float powerOfCompensatingDevice,
                                                          FullInformationResponseDTO fullInformation,
                                                          CompensationDeviceSelectionRepository compensationDeviceSelectionRepository) {


        float avgDailyActivePower = fullInformation.getFullInformation().getAvgDailyActivePower();
        float tgfBeforeCompensation = fullInformation.getFullInformation().getTgF();

        float tgfActualValueCheck = (tgfBeforeCompensation - powerOfCompensatingDevice
                        / (coefTakingIncreasingCosf * avgDailyActivePower));

        if (tgfActualValueCheck >=0.33 && tgfActualValueCheck <= 0.4){
            return new CompensationDevice(compensationDeviceId, nameOfCompensationDevice, powerOfCompensatingDevice);
        }else {
            CompensationDeviceSelection compensationDeviceSelection = compensationDeviceSelectionRepository.findById(compensationDeviceId).get();
            float minPowerOfCompensatingDevice = compensationDeviceSelection.getMinPowerOfCompensatingDevice();
            float maxPowerOfCompensatingDevice = compensationDeviceSelection.getMaxPowerOfCompensatingDevice();
            throw new IncorrectNumberValueException("Incorrect power value of the compensating device, as it should be between "
                    + minPowerOfCompensatingDevice + " and " + maxPowerOfCompensatingDevice);
        }
    }
}
