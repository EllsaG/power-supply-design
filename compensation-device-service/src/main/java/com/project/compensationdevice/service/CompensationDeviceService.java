package com.project.compensationdevice.service;


import com.project.compensationdevice.calculation.CompensationDeviceCalculation;
import com.project.compensationdevice.controller.dto.CompensationDeviceResponseDTO;
import com.project.compensationdevice.entity.CompensationDevice;
import com.project.compensationdevice.entity.CompensationDeviceSelection;
import com.project.compensationdevice.exceptions.InformationNotFoundException;
import com.project.compensationdevice.repository.CompensationDeviceRepository;
import com.project.compensationdevice.repository.CompensationDeviceSelectionRepository;
import com.project.compensationdevice.rest.FullInformationResponseDTO;
import com.project.compensationdevice.rest.FullInformationServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompensationDeviceService {

    private final FullInformationServiceClient fullInformationServiceClient;
    private final CompensationDeviceRepository compensationDeviceRepository;
    private final CompensationDeviceSelectionRepository compensationDeviceSelectionRepository;

    @Autowired
    public CompensationDeviceService(FullInformationServiceClient fullInformationServiceClient,
                                     CompensationDeviceRepository compensationDeviceRepository,
                                     CompensationDeviceSelectionRepository compensationDeviceSelectionRepository) {
        this.fullInformationServiceClient = fullInformationServiceClient;
        this.compensationDeviceRepository = compensationDeviceRepository;
        this.compensationDeviceSelectionRepository = compensationDeviceSelectionRepository;
    }


    public CompensationDeviceResponseDTO saveCompensationDevice(short compensationDeviceId, String nameOfCompensationDevice, float powerOfCompensatingDevice) {

        CompensationDeviceCalculation compensationDeviceCalculation = new CompensationDeviceCalculation();
        FullInformationResponseDTO fullInformationById = fullInformationServiceClient.getFullInformationById(compensationDeviceId);
        CompensationDevice newCompensatingDevice = compensationDeviceCalculation.createNewCompensatingDevice(compensationDeviceId, nameOfCompensationDevice, powerOfCompensatingDevice,
                fullInformationById, compensationDeviceSelectionRepository);
        compensationDeviceRepository.save(newCompensatingDevice);
        return new CompensationDeviceResponseDTO(getAllCompensationDevices(), getAllCompensationDevicesSelectionInformation());

    }

    public void saveCompensationDeviceSelectionInformation(short compensationDeviceId, float avgDailyActivePower, float tgfBeforeCompensation){
        CompensationDeviceCalculation compensationDeviceCalculation = new CompensationDeviceCalculation();
        CompensationDeviceSelection compensationDeviceSelectionInformation = compensationDeviceCalculation
                .createCompensationDeviceSelectionInformation(compensationDeviceId, avgDailyActivePower, tgfBeforeCompensation);
        compensationDeviceSelectionRepository.save(compensationDeviceSelectionInformation);
    }




    public CompensationDeviceResponseDTO updateCompensationDevice(short compensationDeviceId, String nameOfCompensationDevice, float powerOfCompensatingDevice) {
        deleteCompensationDeviceById(compensationDeviceId);
        return saveCompensationDevice(compensationDeviceId, nameOfCompensationDevice, powerOfCompensatingDevice);
    }

    public CompensationDeviceResponseDTO deleteCompensationDeviceById(short compensationDeviceId) {
        compensationDeviceRepository.deleteById(compensationDeviceId);
        return new CompensationDeviceResponseDTO(getAllCompensationDevices(), getAllCompensationDevicesSelectionInformation());
    }

    public void deleteCompensationDeviceSelectionInformationById(short compensationDeviceId) {
        compensationDeviceSelectionRepository.deleteById(compensationDeviceId);

    }


    public CompensationDevice getCompensationDeviceInformationById(short compensationDeviceId) {
        return compensationDeviceRepository.findById(compensationDeviceId)
                .orElseThrow(()->new InformationNotFoundException("Unable to find information about compensation device with id № " + compensationDeviceId));
    }

    public CompensationDeviceSelection getCompensationDeviceSelectionInformationById(short compensationDeviceId) {
        return compensationDeviceSelectionRepository.findById(compensationDeviceId)
                .orElseThrow(()->new InformationNotFoundException("Unable to find information about compensation device selection with id № " + compensationDeviceId));
    }
    public List<CompensationDevice> getAllCompensationDevices() {
        return compensationDeviceRepository.findAll();
    }
    public List<CompensationDeviceSelection> getAllCompensationDevicesSelectionInformation() {
        return compensationDeviceSelectionRepository.findAll();
    }

    public Boolean isAvailable(short compensationDeviceSelectionId) {
        return compensationDeviceSelectionRepository.existsById(compensationDeviceSelectionId);
    }
}
