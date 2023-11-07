package com.project.powertransformerservice.calculation;


import com.project.powertransformerservice.entity.PowerTransformers;
import com.project.powertransformerservice.entity.TransformerSelection;
import com.project.powertransformerservice.exceptions.IncorrectNumberValueException;
import com.project.powertransformerservice.repository.TransformerSelectionRepository;
import com.project.powertransformerservice.rest.FullInformationResponseDTO;

public class TransformerSelectionCalculation {


    public TransformerSelection createPowerTransformerSelectionInformation(short id, float maxFullPower) {
        float lossesOfActivePower = 0.2F * maxFullPower;
        float lossesOfReactivePower = 0.1F * maxFullPower;
        float lossesOfFullPower = (float) Math.sqrt(Math.pow(lossesOfActivePower, 2) + Math.pow(lossesOfReactivePower, 2));

        float ratedPowerForChoosingOfTransformer = Math.round(maxFullPower + lossesOfFullPower * 100.0)/100.0F;
        return new TransformerSelection(id, ratedPowerForChoosingOfTransformer);
    }

    public PowerTransformers createNewPowerTransformer(short id, String modelOfTransformer, float fullPowerOfTransformer,
                                                       float shortCircuitVoltage, float idleLossesOfTransformer,
                                                       float highSideVoltage, float lowSideVoltage, float shortCircuitLosses, float idleCurrent,
                                                       FullInformationResponseDTO fullInformationById, TransformerSelectionRepository transformerSelectionRepository) {

        TransformerSelection transformerSelection = transformerSelectionRepository.findById(id).get();

        float maxFullPower = fullInformationById.getMaxFullPower();
        float coefOfTransformerLoad = Math.round(maxFullPower / fullPowerOfTransformer * 100.0)/100.0F;

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
