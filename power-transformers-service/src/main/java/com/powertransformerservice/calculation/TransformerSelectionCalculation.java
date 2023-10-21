package com.powertransformerservice.calculation;


import com.powertransformerservice.entity.PowerTransformers;
import com.powertransformerservice.entity.TransformerSelection;
import com.powertransformerservice.exceptions.IncorrectNumberValueException;
import com.powertransformerservice.repository.TransformerSelectionRepository;
import com.powertransformerservice.rest.FullInformationResponseDTO;
import com.powertransformerservice.rest.FullInformationServiceClient;

public class TransformerSelectionCalculation {


    public TransformerSelection ratedPowerForChoosingOfTransformer(short id, float maxFullPower) {
        float lossesOfActivePower = (float) (0.2 * maxFullPower);
        float lossesOfReactivePower = (float) (0.1 * maxFullPower);
        float lossesOfFullPower = (float) Math.sqrt(Math.pow(lossesOfActivePower, 2) + Math.pow(lossesOfReactivePower, 2));

        float ratedPowerForChoosingOfTransformer = (float) (Math.round(maxFullPower + lossesOfFullPower * 100.0)/100.0);
        return new TransformerSelection(id, ratedPowerForChoosingOfTransformer);
    }

    public PowerTransformers createNewTransformer(short id, String modelOfTransformer, float fullPowerOfTransformer,
                                                  float shortCircuitVoltage, float idleLossesOfTransformer,
                                                  float highSideVoltage, float lowSideVoltage, float shortCircuitLosses, float idleCurrent,
                                                  FullInformationServiceClient fullInformationServiceClient, TransformerSelectionRepository transformerSelectionRepository) {

        TransformerSelection transformerSelection = transformerSelectionRepository.findById(id).get();
        FullInformationResponseDTO fullInformationById = fullInformationServiceClient.getFullInformationById(id);

        float maxFullPower = fullInformationById.getMaxFullPower();
        float coefOfTransformerLoad = (float) (Math.round(maxFullPower / fullPowerOfTransformer * 100.0)/100.0);

        if (fullPowerOfTransformer >= transformerSelection.getRatedPowerForTransformerSelection()){
            return new PowerTransformers(id, modelOfTransformer, fullPowerOfTransformer, coefOfTransformerLoad,
                    shortCircuitVoltage, idleLossesOfTransformer, highSideVoltage, lowSideVoltage,
                    shortCircuitLosses, idleCurrent);
        }else {
            throw new IncorrectNumberValueException("Incorrect transformer power value, as it should be more than "
                    + transformerSelection.getRatedPowerForTransformerSelection());
        }

    }


}
