package com.startinformationservice.controller;

import com.startinformationservice.controller.dto.StartInformationRequestDTO;
import com.startinformationservice.controller.dto.StartInformationResponseDTO;
import com.startinformationservice.service.StartInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StartInformationController {
    private final StartInformationService startInformationService;

    @Autowired
    public StartInformationController(StartInformationService startInformationService) {
        this.startInformationService = startInformationService;
    }

    @GetMapping("/getAllInformation")
    public StartInformationResponseDTO getAll(){
        return startInformationService.getAllStartInformation();
    }

    @PutMapping("/create")
    public StartInformationResponseDTO createStartInformation(@RequestBody StartInformationRequestDTO startInformationRequestDTO) {
        return startInformationService.saveStartInformation(startInformationRequestDTO.getStartInformId(),
                startInformationRequestDTO.getName(),startInformationRequestDTO.getPower(),
                startInformationRequestDTO.getAmount(), startInformationRequestDTO.getKi(),
                startInformationRequestDTO.getCosf(), startInformationRequestDTO.getTgf());
    }

    @PutMapping("/update")
    public StartInformationResponseDTO updateStartInformation(@RequestBody StartInformationRequestDTO startInformationRequestDTO){
        return startInformationService.updateStartInformation(startInformationRequestDTO.getStartInformId(),
                startInformationRequestDTO.getName(),startInformationRequestDTO.getPower(),
                startInformationRequestDTO.getAmount(), startInformationRequestDTO.getKi(),
                startInformationRequestDTO.getCosf(), startInformationRequestDTO.getTgf());
    }

    @DeleteMapping("/delete/{startInformationId}")
    public StartInformationResponseDTO deleteStartInformation(@PathVariable short startInformationId){
        startInformationService.deleteStartInformationById(startInformationId);
        return startInformationService.getAllStartInformation();
    }

    @GetMapping("/{startInformationId}")
    public Boolean checkAvailability(@PathVariable short startInformationId){
        return startInformationService.isAvailable(startInformationId);
    }


}
