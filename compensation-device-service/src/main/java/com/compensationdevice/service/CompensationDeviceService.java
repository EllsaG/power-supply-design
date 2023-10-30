package com.compensationdevice.service;


import com.compensationdevice.calculation.CompensationDeviceCalculation;
import com.compensationdevice.controller.dto.CompensationDeviceResponseDTO;
import com.compensationdevice.entity.CompensationDevice;
import com.compensationdevice.entity.CompensationDeviceSelection;
import com.compensationdevice.exceptions.InformationNotFoundException;
import com.compensationdevice.repository.CompensationDeviceRepository;
import com.compensationdevice.repository.CompensationDeviceSelectionRepository;
import com.compensationdevice.rest.FullInformationResponseDTO;
import com.compensationdevice.rest.FullInformationServiceClient;
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

    public void updateCompensationDeviceSelectionInformation(short compensationDeviceId, float avgDailyActivePower, float tgfBeforeCompensation) {
        deleteCompensationDeviceSelectionInformationById(compensationDeviceId);
         saveCompensationDeviceSelectionInformation(compensationDeviceId, avgDailyActivePower, tgfBeforeCompensation);
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
