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

    @GetMapping("/startInformation/all")
    public StartInformationResponseDTO getAll(){
        return startInformationService.getAllStartInformation();
    }

    @PostMapping("/startInformation/create")
    public StartInformationResponseDTO createStartInformation(@RequestBody StartInformationRequestDTO startInformationRequestDTO) {
        return startInformationService.save(startInformationRequestDTO.getStartInformId(),
                startInformationRequestDTO.getName(),startInformationRequestDTO.getPower(),
                startInformationRequestDTO.getAmount(), startInformationRequestDTO.getKi(),
                startInformationRequestDTO.getCosf(), startInformationRequestDTO.getTgf());
    }

    @PostMapping("/startInformation/update")
    public StartInformationResponseDTO updateStartInformation(@RequestBody StartInformationRequestDTO startInformationRequestDTO){
        return startInformationService.update(startInformationRequestDTO.getStartInformId(),
                startInformationRequestDTO.getName(),startInformationRequestDTO.getPower(),
                startInformationRequestDTO.getAmount(), startInformationRequestDTO.getKi(),
                startInformationRequestDTO.getCosf(), startInformationRequestDTO.getTgf());
    }

    @DeleteMapping("/startInformation/delete/{startInformationId}")
    public StartInformationResponseDTO deleteStartInformation(@PathVariable short startInformationId){
        startInformationService.delete(startInformationId);
        return startInformationService.getAllStartInformation();
    }

    @GetMapping("/startInformation/{checkStartInformationId}")
    public Boolean checkAvailability(@PathVariable short checkStartInformationId){
        return startInformationService.checkAvailability(checkStartInformationId);
    }


}
