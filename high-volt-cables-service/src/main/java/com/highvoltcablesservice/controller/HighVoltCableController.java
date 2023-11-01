package com.highvoltcablesservice.controller;


import com.highvoltcablesservice.controller.dto.HighVoltCablesSelectionInformationRequestDTO;
import com.highvoltcablesservice.controller.dto.HighVoltCablesSelectionInformationResponseDTO;
import com.highvoltcablesservice.controller.dto.HighVoltInformationRequestDTO;
import com.highvoltcablesservice.controller.dto.HighVoltInformationResponseDTO;
import com.highvoltcablesservice.service.HighVoltCablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HighVoltCableController {

    private final HighVoltCablesService highVoltCablesService;

    @Autowired
    public HighVoltCableController(HighVoltCablesService highVoltCablesService) {
        this.highVoltCablesService = highVoltCablesService;
    }

    @GetMapping("/selectionInformation/getAllInformation")
    public HighVoltCablesSelectionInformationResponseDTO getAllHighVoltCableSelectionInformation(){
        return new HighVoltCablesSelectionInformationResponseDTO(highVoltCablesService.getAllHighVoltCableSelectionInformation());
    }

    @GetMapping("/getAllInformation")
    public HighVoltInformationResponseDTO getAllHighVoltCables(){
        return new HighVoltInformationResponseDTO(highVoltCablesService.getAllHighVoltInformation(),
                highVoltCablesService.getAllHighVoltCableSelectionInformation());
    }

    @PutMapping("/create/selectionInformation")
    public HighVoltCablesSelectionInformationResponseDTO createHighVoltCablesSelectionInformation(@RequestBody HighVoltInformationRequestDTO highVoltInformationRequestDTO) {
        return highVoltCablesService.saveHighVoltCablesSelectionInformation(highVoltInformationRequestDTO.getHighVoltInformationId(),
                highVoltInformationRequestDTO.getBaseVoltage(),highVoltInformationRequestDTO.getBaseFullPower(),
                highVoltInformationRequestDTO.getRelativeBaselineUnrestrictedPowerResistance(),highVoltInformationRequestDTO.getHighVoltageAirLineLength(),
                highVoltInformationRequestDTO.getHeadTransformerFullPower(),highVoltInformationRequestDTO.getShortCircuitVoltage(),
                highVoltInformationRequestDTO.getCableLineLength(),highVoltInformationRequestDTO.getRatedVoltageOfHigherVoltageWindingOfTransformer(),
                highVoltInformationRequestDTO.getInductiveResistanceList());

    }

    @PutMapping("/create/highVoltCable")
    public HighVoltInformationResponseDTO createNewHighVoltCable(@RequestBody HighVoltCablesSelectionInformationRequestDTO highVoltCablesSelectionInformationRequestDTO) {
        return highVoltCablesService.saveNewHighVoltCable(
                highVoltCablesSelectionInformationRequestDTO.getHighVoltCableSelectionId(),
                highVoltCablesSelectionInformationRequestDTO.getCableType());
    }
    @PutMapping("/update/selectionInformation")
    public HighVoltCablesSelectionInformationResponseDTO updateHighVoltCablesSelectionInformation(@RequestBody HighVoltInformationRequestDTO highVoltInformationRequestDTO) {
        return highVoltCablesService.updateHighVoltCableSelectionInformation(highVoltInformationRequestDTO.getHighVoltInformationId(),
                highVoltInformationRequestDTO.getBaseVoltage(),highVoltInformationRequestDTO.getBaseFullPower(),
                highVoltInformationRequestDTO.getRelativeBaselineUnrestrictedPowerResistance(),highVoltInformationRequestDTO.getHighVoltageAirLineLength(),
                highVoltInformationRequestDTO.getHeadTransformerFullPower(),highVoltInformationRequestDTO.getShortCircuitVoltage(),
                highVoltInformationRequestDTO.getCableLineLength(),highVoltInformationRequestDTO.getRatedVoltageOfHigherVoltageWindingOfTransformer(),
                highVoltInformationRequestDTO.getInductiveResistanceList());

    }

    @PutMapping("/update/highVoltCable")
    public HighVoltInformationResponseDTO updateNewHighVoltCable(@RequestBody HighVoltCablesSelectionInformationRequestDTO highVoltCablesSelectionInformationRequestDTO) {
        return highVoltCablesService.updateHighVoltCable(
                highVoltCablesSelectionInformationRequestDTO.getHighVoltCableSelectionId(),
                highVoltCablesSelectionInformationRequestDTO.getCableType());
    }

    @DeleteMapping("/delete/{highVoltInformationId}")
    public HighVoltCablesSelectionInformationResponseDTO deleteCableById(@PathVariable short highVoltInformationId){
        return highVoltCablesService.deleteHighVoltCableById(highVoltInformationId);
    }
    @DeleteMapping("/delete/selectionInformation/{highVoltInformationId}")
    public HighVoltInformationResponseDTO deleteHighVoltSelectionInformationById(@PathVariable short highVoltInformationId){
        return highVoltCablesService.deleteHighVoltSelectionInformationById(highVoltInformationId);
    }




}
