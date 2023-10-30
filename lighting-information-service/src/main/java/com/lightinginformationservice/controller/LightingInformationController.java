package com.lightinginformationservice.controller;


import com.lightinginformationservice.controller.dto.LightingInformationRequestDTO;
import com.lightinginformationservice.controller.dto.LightingInformationResponseDTO;
import com.lightinginformationservice.controller.dto.LuminaireSelectionRequestDTO;
import com.lightinginformationservice.controller.dto.LuminaireSelectionResponseDTO;
import com.lightinginformationservice.service.LightingInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LightingInformationController {

    private final LightingInformationService lightingInformationService;

    @Autowired
    public LightingInformationController(LightingInformationService lightingInformationService) {
        this.lightingInformationService = lightingInformationService;
    }



    @GetMapping("/getAllInformation")
    public LightingInformationResponseDTO getAllLightingInformation(){
        return lightingInformationService.getAllLightingInformation();
    }

    @GetMapping("/luminaireSelection/getAllInformation")
    public LuminaireSelectionResponseDTO getAllLuminaireSelectionInformation(){
        return lightingInformationService.getAllLuminaireSelectionInformation();
    }

    @PutMapping("/create/lighting")
    public LightingInformationResponseDTO createLighting(@RequestBody LightingInformationRequestDTO lightingInformationRequestDTO) {
        return lightingInformationService.saveLightingInformation(lightingInformationRequestDTO.getLightingInformationId(),
                lightingInformationRequestDTO.getModelOfLuminaire(), lightingInformationRequestDTO.getModelOfLamp(),
                lightingInformationRequestDTO.getLightFluxOneLamp(), lightingInformationRequestDTO.getAmountOfLampsInOneLuminaire(),
                lightingInformationRequestDTO.getActivePowerOneLamp());
    }

    @PutMapping("/create/selectionInformation")
    public LuminaireSelectionResponseDTO luminariesSelection(@RequestBody LuminaireSelectionRequestDTO luminaireSelectionRequestDTO) {
        return lightingInformationService.saveLuminaireSelectionInformation(luminaireSelectionRequestDTO.getLightingInformationId(),
                luminaireSelectionRequestDTO.getHeightProductionHall(),
                luminaireSelectionRequestDTO.getWidthProductionHall(), luminaireSelectionRequestDTO.getLengthProductionHall());

    }

    @PutMapping("/update/lighting")
    public LightingInformationResponseDTO updateLighting(@RequestBody LightingInformationRequestDTO lightingInformationRequestDTO) {
        return lightingInformationService.updateLightingInformation(lightingInformationRequestDTO.getLightingInformationId(),
                lightingInformationRequestDTO.getModelOfLuminaire(), lightingInformationRequestDTO.getModelOfLamp(),
                lightingInformationRequestDTO.getLightFluxOneLamp(), lightingInformationRequestDTO.getAmountOfLampsInOneLuminaire(),
                lightingInformationRequestDTO.getActivePowerOneLamp());
    }

    @PutMapping("/update/selectionInformation")
    public LuminaireSelectionResponseDTO updateLuminariesSelectionInformation(@RequestBody LuminaireSelectionRequestDTO luminaireSelectionRequestDTO) {
        return lightingInformationService.updateLuminaireSelectionInformation(luminaireSelectionRequestDTO.getLightingInformationId(),
                luminaireSelectionRequestDTO.getHeightProductionHall(), luminaireSelectionRequestDTO.getWidthProductionHall(),
                luminaireSelectionRequestDTO.getLengthProductionHall());

    }

    @DeleteMapping("/delete/{lightingInformationId}")
    public LightingInformationResponseDTO deleteLightingById(@PathVariable short lightingInformationId){
        return lightingInformationService.deleteLightingInformationById(lightingInformationId);
    }

    @DeleteMapping("/delete/selectionInformation/{lightingInformationId}")
    public LuminaireSelectionResponseDTO deleteLuminaireById(@PathVariable short lightingInformationId){
        return lightingInformationService.deleteLuminaireById(lightingInformationId);
    }





}
