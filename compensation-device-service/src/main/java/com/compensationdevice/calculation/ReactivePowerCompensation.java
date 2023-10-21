package com.compensationdevice.calculation;


import com.compensationdevice.entity.CompensationDevice;
import com.compensationdevice.entity.CompensationDeviceSelection;
import com.compensationdevice.exceptions.IncorrectNumberValueException;
import com.compensationdevice.repository.CompensationDeviceSelectionRepository;
import com.compensationdevice.rest.FullInformationResponseDTO;
import com.compensationdevice.rest.FullInformationServiceClient;

public class ReactivePowerCompensation {
    private static final float coefTakingIncreasingCosf = 0.9F;

    public CompensationDeviceSelection powerOfCompensatingDevice(short id, float avgDailyActivePower, float tgfBeforeCompensation) {
        float minTgfRecommendedAfterCompensation = 0.33F;
        float maxTgfRecommendedAfterCompensation = 0.4F;

        float maxPowerOfCompensatingDevice = (float) (Math.round(avgDailyActivePower * coefTakingIncreasingCosf
                        * (tgfBeforeCompensation - minTgfRecommendedAfterCompensation) * 100.0) / 100.0);
        float  minPowerOfCompensatingDevice= (float) (Math.round(avgDailyActivePower * coefTakingIncreasingCosf
                        * (tgfBeforeCompensation - maxTgfRecommendedAfterCompensation) * 100.0) / 100.0);

        return new CompensationDeviceSelection(id, minPowerOfCompensatingDevice, maxPowerOfCompensatingDevice);
    }

    public CompensationDevice createNewCompensatingDevice(short id, String nameOfCompensationDevice, float powerOfCompensatingDevice,
                                                          FullInformationServiceClient fullInformationServiceClient,
                                                          CompensationDeviceSelectionRepository compensationDeviceSelectionRepository) {
        FullInformationResponseDTO fullInformation = fullInformationServiceClient.getFullInformationById(id);

        float avgDailyActivePower = fullInformation.getAvgDailyActivePower();
        float tgfBeforeCompensation = fullInformation.getTgF();

        float tgfActualValueCheck = (tgfBeforeCompensation - powerOfCompensatingDevice
                        / (coefTakingIncreasingCosf * avgDailyActivePower));

        if (tgfActualValueCheck >=0.33 && tgfActualValueCheck <= 0.4){
            return new CompensationDevice(id, nameOfCompensationDevice, powerOfCompensatingDevice);
        }else {
            CompensationDeviceSelection compensationDeviceSelection = compensationDeviceSelectionRepository.findById(id).get();
            float minPowerOfCompensatingDevice = compensationDeviceSelection.getMinPowerOfCompensatingDevice();
            float maxPowerOfCompensatingDevice = compensationDeviceSelection.getMaxPowerOfCompensatingDevice();
            throw new IncorrectNumberValueException("Incorrect power value of the compensating device, as it should be between "
                    + minPowerOfCompensatingDevice + " and " + maxPowerOfCompensatingDevice);
        }
    }
}
