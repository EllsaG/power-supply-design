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

    public StartInformation getStartInformationById(short startInformationId) {
        return startInformationRepository.findById(startInformationId)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about equipment with id № " + startInformationId));
    }

    public Boolean isAvailable(short startInformationId) {
        return startInformationRepository.existsById(startInformationId);
    }


    public StartInformationResponseDTO getAllStartInformation() {
        return new StartInformationResponseDTO(startInformationRepository.findAll());
    }







}
