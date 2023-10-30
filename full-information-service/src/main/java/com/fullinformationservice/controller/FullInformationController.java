package com.fullinformationservice.controller;


import com.fullinformationservice.controller.dto.FullInformationMainBusbarRequestDTO;
import com.fullinformationservice.controller.dto.FullInformationRequestDTO;
import com.fullinformationservice.controller.dto.FullInformationResponseDTO;
import com.fullinformationservice.entity.FullStartInformation;
import com.fullinformationservice.service.FullInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController

public class FullInformationController {

    private final FullInformationService fullInformationService;

    @Autowired
    public FullInformationController(FullInformationService fullInformationService) {
        this.fullInformationService = fullInformationService;
    }

    @GetMapping("/getAllInformation")
    public FullInformationResponseDTO getAll(){
        return fullInformationService.getAllFullInformation();
    }

    @PutMapping("/create")
    public FullInformationResponseDTO create(@RequestBody FullInformationRequestDTO fullInformationRequestDTO) {
        return fullInformationService.saveNewBusbar(fullInformationRequestDTO.getFullInformationId(),
                fullInformationRequestDTO.getNameOfBusbar(),
                fullInformationRequestDTO.getFullStartInformId().stream()
                        .map(e -> new FullStartInformation(e.getNumberOfBusbar(), e.getNumberOfEquipment(), e.getAmountOfEquipment()))
                        .collect(Collectors.toList()));
    }

    @PutMapping("/create/main")
    public FullInformationResponseDTO createMainBusbar(@RequestBody FullInformationMainBusbarRequestDTO fullInformationMainBusbarRequestDTO) {
        return fullInformationService.saveMainBusbar(fullInformationMainBusbarRequestDTO.getFullInformationId(),
                fullInformationMainBusbarRequestDTO.getBusbarName(),
                fullInformationMainBusbarRequestDTO.getNumbersBusbarsIncludedInMain());
    }

    @PutMapping("/update")
    public FullInformationResponseDTO update(@RequestBody FullInformationRequestDTO fullInformationRequestDTO) {
        return fullInformationService.updateBusbar(fullInformationRequestDTO.getFullInformationId(),
                fullInformationRequestDTO.getNameOfBusbar(),
                fullInformationRequestDTO.getFullStartInformId().stream()
                        .map(e -> new FullStartInformation(e.getNumberOfBusbar(), e.getNumberOfEquipment(), e.getAmountOfEquipment()))
                        .collect(Collectors.toList()));
    }

    @PutMapping("/update/main")
    public FullInformationResponseDTO updateMainBusbar(@RequestBody FullInformationMainBusbarRequestDTO fullInformationMainBusbarRequestDTO) {
        return fullInformationService.updateMainBusbar(fullInformationMainBusbarRequestDTO.getFullInformationId(),
                fullInformationMainBusbarRequestDTO.getBusbarName(),
                fullInformationMainBusbarRequestDTO.getNumbersBusbarsIncludedInMain());
    }

    @DeleteMapping("/delete/{fullInformationId}")
    public FullInformationResponseDTO delete(@PathVariable  short fullInformationId){
        return fullInformationService.deleteFullInformationById(fullInformationId);
    }

    @GetMapping("/check/{fullInformationId}")
    public Boolean checkAvailability(@PathVariable short fullInformationId){
        return fullInformationService.isAvailable(fullInformationId);
    }

}
