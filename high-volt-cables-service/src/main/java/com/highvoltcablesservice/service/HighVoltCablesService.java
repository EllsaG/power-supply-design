package com.highvoltcablesservice.service;


import com.highvoltcablesservice.calculation.HighVoltCalculation;
import com.highvoltcablesservice.controller.dto.HighVoltCablesResponseDTO;
import com.highvoltcablesservice.controller.dto.HighVoltCablesSelectionInformationResponseDTO;
import com.highvoltcablesservice.controller.dto.HighVoltInformationResponseDTO;
import com.highvoltcablesservice.entity.HighVoltCables;
import com.highvoltcablesservice.entity.HighVoltCablesSelection;
import com.highvoltcablesservice.entity.HighVoltInformation;
import com.highvoltcablesservice.repository.HighVoltCablesRepository;
import com.highvoltcablesservice.repository.HighVoltCablesSelectionRepository;
import com.highvoltcablesservice.repository.HighVoltInformationRepository;
import com.highvoltcablesservice.rest.PowerTransformersServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighVoltCablesService {

    private final HighVoltCablesSelectionRepository highVoltCablesSelectionRepository;
    private final HighVoltInformationRepository highVoltInformationRepository;
    private final HighVoltCablesRepository highVoltCablesRepository;
    private final PowerTransformersServiceClient powerTransformersServiceClient;

    @Autowired
    public HighVoltCablesService(HighVoltCablesSelectionRepository highVoltCablesSelectionRepository,
                                 HighVoltInformationRepository highVoltInformationRepository,
                                 HighVoltCablesRepository highVoltCablesRepository,
                                 PowerTransformersServiceClient powerTransformersServiceClient) {
        this.highVoltCablesSelectionRepository = highVoltCablesSelectionRepository;
        this.highVoltInformationRepository = highVoltInformationRepository;
        this.highVoltCablesRepository = highVoltCablesRepository;
        this.powerTransformersServiceClient = powerTransformersServiceClient;
    }


    public HighVoltCablesSelectionInformationResponseDTO saveHighVoltCablesSelectionInformation(short highVoltInformationId, short baseVoltage, short baseFullPower,
                                                                                                float relativeBaselineUnrestrictedPowerResistance,
                                                                                                float highVoltageAirLineLength, float headTransformerFullPower,
                                                                                                float shortCircuitVoltage, float cableLineLength,
                                                                                                float ratedVoltageOfHigherVoltageWindingOfTransformer,
                                                                                                List<Float> inductiveResistanceList) {

        HighVoltCalculation highVoltCalculation = new HighVoltCalculation();
        HighVoltInformation highVoltInformation = highVoltCalculation.highVoltInformationCalculation(highVoltInformationId, baseVoltage, baseFullPower,
                relativeBaselineUnrestrictedPowerResistance, highVoltageAirLineLength, headTransformerFullPower, shortCircuitVoltage,
                cableLineLength, ratedVoltageOfHigherVoltageWindingOfTransformer, inductiveResistanceList, powerTransformersServiceClient);

        HighVoltCablesSelection highVoltCableSelection = highVoltCalculation.createHighVoltCablesSelectionInformationResponse(highVoltInformation);

        highVoltCablesSelectionRepository.save(highVoltCableSelection);
        highVoltInformationRepository.save(highVoltInformation);

        return new HighVoltCablesSelectionInformationResponseDTO(getAllHighVoltCableSelectionInformation());

    }

    public HighVoltCablesResponseDTO saveNewHighVoltCable(short id, String cableType) {
        HighVoltCalculation highVoltCalculation = new HighVoltCalculation();
        HighVoltCables newHighVoltCable = highVoltCalculation.createNewHighVoltCable(id, cableType, highVoltInformationRepository);
        highVoltCablesRepository.save(newHighVoltCable);
        return new HighVoltCablesResponseDTO(getAllHighVoltCables());
    }




    public HighVoltCablesSelectionInformationResponseDTO updateHighVoltCableSelectionInformation(short highVoltInformationId, short baseVoltage, short baseFullPower,
                                                                                                 float relativeBaselineUnrestrictedPowerResistance,
                                                                                                 float highVoltageAirLineLength, float headTransformerFullPower, float shortCircuitVoltage,
                                                                                                 float cableLineLength, float ratedVoltageOfHigherVoltageWindingOfTransformer,
                                                                                                 List<Float> inductiveResistanceList) {

        deleteHighVoltSelectionInformationById(highVoltInformationId);

        return saveHighVoltCablesSelectionInformation(highVoltInformationId, baseVoltage, baseFullPower,
                relativeBaselineUnrestrictedPowerResistance, highVoltageAirLineLength, headTransformerFullPower, shortCircuitVoltage,
                cableLineLength, ratedVoltageOfHigherVoltageWindingOfTransformer, inductiveResistanceList);

    }

    public HighVoltCablesResponseDTO updateHighVoltCable(short highVoltInformationId, String cableType) {
        deleteHighVoltCableById(highVoltInformationId);
        return saveNewHighVoltCable(highVoltInformationId, cableType);
    }

    public HighVoltCablesResponseDTO deleteHighVoltCableById(short highVoltInformationId) {
        if (highVoltCablesRepository.existsById(highVoltInformationId)){
            highVoltCablesRepository.deleteById(highVoltInformationId);
        }

        return new HighVoltCablesResponseDTO(getAllHighVoltCables());
    }

    public HighVoltInformationResponseDTO deleteHighVoltSelectionInformationById(short highVoltInformationId ) {

        if (highVoltInformationRepository.existsById(highVoltInformationId)){
            highVoltInformationRepository.deleteById(highVoltInformationId);
        }
        if (highVoltCablesSelectionRepository.existsById(highVoltInformationId)){
            highVoltCablesSelectionRepository.deleteById(highVoltInformationId);
        }

        return new HighVoltInformationResponseDTO(getAllHighVoltInformation(), getAllHighVoltCableSelectionInformation());
    }



    public List<HighVoltInformation> getAllHighVoltInformation() {
        return highVoltInformationRepository.findAll();
    }

    public List<HighVoltCablesSelection> getAllHighVoltCableSelectionInformation() {
        return highVoltCablesSelectionRepository.findAll();
    }

    public List<HighVoltCables> getAllHighVoltCables() {
        return highVoltCablesRepository.findAll();
    }

}
