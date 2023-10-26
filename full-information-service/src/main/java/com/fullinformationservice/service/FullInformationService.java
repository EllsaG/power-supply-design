package com.fullinformationservice.service;



import com.fullinformationservice.calculation.FullInformationCalculation;
import com.fullinformationservice.controller.dto.FullInformationResponseDTO;
import com.fullinformationservice.entity.FullInformation;
import com.fullinformationservice.entity.FullStartInformation;
import com.fullinformationservice.exceptions.InformationNotFoundException;
import com.fullinformationservice.repository.FullInformationRepository;
import com.fullinformationservice.repository.FullStartInformationRepository;
import com.fullinformationservice.rest.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FullInformationService {

    private final FullInformationRepository fullInformationRepository;
    private final StartInformationServiceClient startInformationServiceClient;
    private final CompensationDeviceServiceClient compensationDeviceServiceClient;
    private final PowerTransformerSelectionServiceClient powerTransformerSelectionServiceClient;
    private final FullStartInformationRepository fullStartInformationRepository;

    @Autowired
    public FullInformationService(FullInformationRepository fullInformationRepository,
                                  StartInformationServiceClient startInformationServiceClient,
                                  CompensationDeviceServiceClient compensationDeviceServiceClient,
                                  PowerTransformerSelectionServiceClient powerTransformerSelectionServiceClient,
                                  FullStartInformationRepository fullStartInformationRepository) {
        this.fullInformationRepository = fullInformationRepository;
        this.startInformationServiceClient = startInformationServiceClient;
        this.compensationDeviceServiceClient = compensationDeviceServiceClient;
        this.powerTransformerSelectionServiceClient = powerTransformerSelectionServiceClient;
        this.fullStartInformationRepository = fullStartInformationRepository;
    }

    public FullInformationResponseDTO saveNewBusbar(short fullInformationId, String nameOfBusbar,
                                                    List<FullStartInformation> numbersAndAmountOfEquipments) {
        FullInformationCalculation fullInformationCalculation = new FullInformationCalculation();
        FullInformation fullInformation = fullInformationCalculation.calculation(fullInformationRepository,
                 fullInformationId, nameOfBusbar, numbersAndAmountOfEquipments);
        List<FullStartInformation> informationAboutBusbarIncludedEquipment = fullInformationCalculation.
                getInformationAboutBusbarIncludedEquipment( numbersAndAmountOfEquipments, startInformationServiceClient);

        fullInformationRepository.save(fullInformation);
        fullStartInformationRepository.saveAll(informationAboutBusbarIncludedEquipment);

        return getAllFullInformation();
    }

    public FullInformationResponseDTO saveMainBusbar(short fullInformationId, String nameOfBusbar,
                                                     List<Short> numbersBusbarsIncludedInMain) {
        FullInformationCalculation fullInformationCalculation = new FullInformationCalculation();
        FullInformation fullInformation = fullInformationCalculation.calculationMainBusbar(fullInformationRepository,
                fullInformationId, nameOfBusbar, numbersBusbarsIncludedInMain);

        compensationDeviceServiceClient.saveCompensationDeviceSelectionInformation(
                new CompensationDeviceSelectionInformationRequestDTO(fullInformationId, fullInformation.getAvgDailyActivePower(), fullInformation.getTgF()));
        powerTransformerSelectionServiceClient.savePowerTransformerSelectionInformation(
                new PowerTransformerSelectionInformationRequestDTO(fullInformationId, fullInformation.getMaxFullPower()));
        fullInformationRepository.save(fullInformation);

        return getAllFullInformation();
    }

    public FullInformation getInformationById(short fullInformationId) {
        return fullInformationRepository.findById(fullInformationId)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about busbar with id № " + fullInformationId));
    }

    public FullInformationResponseDTO getAllFullInformation() {
        return new FullInformationResponseDTO(fullInformationRepository.findAll());
    }

    public FullInformationResponseDTO updateBusbar(short fullInformationId, String nameOfBusbar,
                                                   List<FullStartInformation> numbersAndAmountOfEquipments) {
        saveNewBusbar(fullInformationId, nameOfBusbar, numbersAndAmountOfEquipments);
        return getAllFullInformation();
    }

    public FullInformationResponseDTO updateMainBusbar(short fullInformationId, String nameOfBusbar,
                                                       List<Short> numbersBusbarsIncludedInMain) {
        saveMainBusbar(fullInformationId, nameOfBusbar, numbersBusbarsIncludedInMain);
        return getAllFullInformation();
    }

    public FullInformationResponseDTO deleteFullInformationById(short fullInformationId) {

        fullInformationRepository.deleteById(fullInformationId);
        if (compensationDeviceServiceClient.checkAvailability(fullInformationId)) {
            compensationDeviceServiceClient.deleteCompensationDeviceSelectionInformationById(fullInformationId);
        }
        if (powerTransformerSelectionServiceClient.checkAvailability(fullInformationId)) {
            powerTransformerSelectionServiceClient.deletePowerTransformerSelectionInformationById(fullInformationId);
        }
        return getAllFullInformation();
    }

    public Boolean isAvailable(short fullInformationId) {
        return fullInformationRepository.existsById(fullInformationId);
    }

}
