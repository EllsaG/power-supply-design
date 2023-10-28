package com.lightinginformationservice.service;


import com.lightinginformationservice.calculation.LightingCalculation;
import com.lightinginformationservice.controller.dto.LightingInformationResponseDTO;
import com.lightinginformationservice.controller.dto.LuminaireSelectionResponseDTO;
import com.lightinginformationservice.entity.LightInformation;
import com.lightinginformationservice.entity.LuminaireSelection;
import com.lightinginformationservice.exceptions.InformationNotFoundException;
import com.lightinginformationservice.repository.LightingInformationRepository;
import com.lightinginformationservice.repository.LuminaireSelectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LightingInformationService {

    private final LightingInformationRepository lightingInformationRepository;
    private final LuminaireSelectionRepository luminaireSelectionRepository;

    @Autowired
    public LightingInformationService(LightingInformationRepository lightingInformationRepository,
                                      LuminaireSelectionRepository luminaireSelectionRepository) {
        this.lightingInformationRepository = lightingInformationRepository;
        this.luminaireSelectionRepository = luminaireSelectionRepository;
    }

    public LuminaireSelectionResponseDTO saveLuminaireSelectionInformation(short lightingInformationId, float heightProductionHall,
                                                                                       float widthProductionHall, float lengthProductionHall) {
        LightingCalculation lightingCalculation = new LightingCalculation();
        LuminaireSelection luminaireSelection = lightingCalculation.lightingCalculation(lightingInformationId,
                heightProductionHall, widthProductionHall, lengthProductionHall, luminaireSelectionRepository);
        luminaireSelectionRepository.save(luminaireSelection);

        return lightingCalculation.forResponseChooseLuminaries(luminaireSelectionRepository);
    }

    public LightingInformationResponseDTO saveLightingInformation(short lightingInformationId, String modelOfLuminaire, String modelOfLamp, float lightFluxOneLamp,
                                                                  short amountOfLampsInOneLuminaire, float activePowerOneLamp) {
        LightingCalculation lightingCalculation = new LightingCalculation();
        LightInformation lightInformation = lightingCalculation.electricCalculation(luminaireSelectionRepository, lightingInformationRepository, lightingInformationId, modelOfLuminaire, modelOfLamp, lightFluxOneLamp, amountOfLampsInOneLuminaire, activePowerOneLamp);
        lightingInformationRepository.save(lightInformation);

        return getAllLightingInformation();
    }

    public LightingInformationResponseDTO updateLightingInformation(short lightingInformationId, String modelOfLuminaire, String modelOfLamp, float lightFluxOneLamp,
                                                                    short amountOfLampsInOneLuminaire, float activePowerOneLamp) {
        deleteLightingInformationById(lightingInformationId);
        return saveLightingInformation(lightingInformationId, modelOfLuminaire, modelOfLamp,
                lightFluxOneLamp, amountOfLampsInOneLuminaire, activePowerOneLamp);
    }

    public LuminaireSelectionResponseDTO updateLuminaireSelectionInformation(short lightingInformationId, float heightProductionHall,
                                                                             float widthProductionHall, float lengthProductionHall) {
        deleteLuminaireById(lightingInformationId);
        return saveLuminaireSelectionInformation(lightingInformationId, heightProductionHall, widthProductionHall, lengthProductionHall);
    }

    public LightingInformationResponseDTO deleteLightingInformationById(short lightingInformationId) {
        lightingInformationRepository.deleteById(lightingInformationId);
        return getAllLightingInformation();

    }

    public LuminaireSelectionResponseDTO deleteLuminaireById(short lightingInformationId) {
        luminaireSelectionRepository.deleteById(lightingInformationId);
        return getAllLuminaireSelectionInformation();

    }



    public LightInformation getLightingInformationById(short lightingInformationId) {
        return lightingInformationRepository.findById(lightingInformationId)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about lighting with id № " + lightingInformationId));
    }
    public LuminaireSelection getLuminaireById(short lightingInformationId) {
        return luminaireSelectionRepository.findById(lightingInformationId)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about luminaire with id № " + lightingInformationId));
    }

    public LightingInformationResponseDTO getAllLightingInformation() {
        return new LightingInformationResponseDTO(lightingInformationRepository.findAll());
    }

    public LuminaireSelectionResponseDTO getAllLuminaireSelectionInformation() {
        LightingCalculation lightingCalculation = new LightingCalculation();
        return lightingCalculation.forResponseChooseLuminaries(luminaireSelectionRepository);
    }







}
