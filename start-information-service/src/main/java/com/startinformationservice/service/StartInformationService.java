package com.startinformationservice.service;


import com.startinformationservice.calculation.StartInformationCalculation;
import com.startinformationservice.controller.dto.StartInformationResponseDTO;
import com.startinformationservice.entity.StartInformation;
import com.startinformationservice.exceptions.InformationNotFoundException;
import com.startinformationservice.repository.StartInformationRepository;
import com.startinformationservice.rest.ProtectiveEquipmentServiceClient;
import com.startinformationservice.rest.ProtectiveEquipmentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StartInformationService {

    private final StartInformationRepository startInformationRepository;
    private final ProtectiveEquipmentServiceClient protectiveEquipmentServiceClient;

    @Autowired
    public StartInformationService(StartInformationRepository startInformationRepository,
                                   ProtectiveEquipmentServiceClient protectiveEquipmentServiceClient) {
        this.startInformationRepository = startInformationRepository;
        this.protectiveEquipmentServiceClient = protectiveEquipmentServiceClient;
    }


    public StartInformationResponseDTO saveStartInformation(short startInformationId, String name, float power, short amount,
                                                            float ki, float cosf, float tgf) {
        StartInformationCalculation startInformationCalculation = new StartInformationCalculation();
        StartInformation startInformation = startInformationCalculation
                .createIfDontExist(startInformationRepository, startInformationId, name, power, amount, ki, cosf, tgf);

        protectiveEquipmentServiceClient.saveProtectiveEquipmentSelectionInformation(new ProtectiveEquipmentRequestDTO(
                startInformation.getStartInformationId(), startInformation.getActivePower(), startInformation.getCosf()));

        startInformationRepository.save(startInformation);

        return getAllStartInformation();
    }

    public StartInformationResponseDTO updateStartInformation(short startInformationId, String name, float power, short amount,
                                                              float ki, float cosf, float tgf) {

        deleteStartInformationById(startInformationId);

        return saveStartInformation( startInformationId,  name,  power,  amount, ki,  cosf,  tgf);
    }

    public void deleteStartInformationById(short startInformationId) {

        if (startInformationRepository.existsById(startInformationId)){
            startInformationRepository.deleteById(startInformationId);
        }

        if (protectiveEquipmentServiceClient.checkAvailability(startInformationId)){
            protectiveEquipmentServiceClient.deleteProtectiveEquipmentSelectionInformationById(startInformationId);
        }
    }

    public StartInformationResponseDTO getStartInformationByIdList(List<Short> idList) {

        List<StartInformation> allById = startInformationRepository.findAllById(idList);
        List<Short> startInformationIdList = allById.stream()
                .map(StartInformation::getStartInformationId)
                .collect(Collectors.toList());

        List<Short> equipmentsIdsNotFound  = new ArrayList<>();
            for(Short sh:idList){
                if (!startInformationIdList.contains(sh)){
                    equipmentsIdsNotFound.add(sh);
                }
            }
        if (startInformationIdList.size() == idList.size()){
            return new StartInformationResponseDTO(allById);
        }else {
            throw new InformationNotFoundException("Information about equipments with id's № "+ equipmentsIdsNotFound + " not founded");
        }
    }

    public Boolean isAvailable(short startInformationId) {
        return startInformationRepository.existsById(startInformationId);
    }


    public StartInformationResponseDTO getAllStartInformation() {
        return new StartInformationResponseDTO(startInformationRepository.findAll());
    }


}
