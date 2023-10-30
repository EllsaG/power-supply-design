package com.protectiveequipmentservice.service;

import com.protectiveequipmentservice.calculation.ProtectiveEquipmentCalculation;
import com.protectiveequipmentservice.controller.dto.ProtectiveEquipmentResponseDTO;
import com.protectiveequipmentservice.entity.ProtectiveEquipment;
import com.protectiveequipmentservice.entity.ProtectiveEquipmentSelection;
import com.protectiveequipmentservice.exeptions.InformationNotFoundException;
import com.protectiveequipmentservice.repository.ProtectiveEquipmentRepository;
import com.protectiveequipmentservice.repository.ProtectiveEquipmentSelectionRepository;
import com.protectiveequipmentservice.rest.StartInformationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProtectiveEquipmentService {

    private final ProtectiveEquipmentRepository protectiveEquipmentRepository;
    private final ProtectiveEquipmentSelectionRepository protectiveEquipmentSelectionRepository;
    private final StartInformationClient startInformationClient;

    @Autowired
    public ProtectiveEquipmentService(ProtectiveEquipmentRepository protectiveEquipmentRepository,
                                      ProtectiveEquipmentSelectionRepository protectiveEquipmentSelectionRepository,
                                      StartInformationClient startInformationClient) {
        this.protectiveEquipmentRepository = protectiveEquipmentRepository;
        this.protectiveEquipmentSelectionRepository = protectiveEquipmentSelectionRepository;
        this.startInformationClient = startInformationClient;
    }



    public ProtectiveEquipmentResponseDTO saveProtectiveEquipment(short id, float nominalCurrentOfThermalRelease, float nominalCurrentOfElectromagneticRelease,
                                               float nominalCurrentOfCircuitBreaker, String typeOfCircuitBreaker, String cableType) {

        ProtectiveEquipmentCalculation protectiveEquipmentCalculation = new ProtectiveEquipmentCalculation();
        ProtectiveEquipment newProtectiveEquipment = protectiveEquipmentCalculation.createNewProtectiveEquipment(id, nominalCurrentOfThermalRelease,
                nominalCurrentOfElectromagneticRelease, nominalCurrentOfCircuitBreaker, typeOfCircuitBreaker, cableType,
                startInformationClient, protectiveEquipmentSelectionRepository);

        protectiveEquipmentRepository.save(newProtectiveEquipment);

        return new ProtectiveEquipmentResponseDTO(getAllProtectiveEquipment(), getAllProtectiveEquipmentSelectionInformation());
    }

    public void saveProtectiveEquipmentSelectionInformation(short startInformationId, float activePower, float cosf) {

        ProtectiveEquipmentCalculation protectiveEquipmentCalculation = new ProtectiveEquipmentCalculation();
        ProtectiveEquipmentSelection newProtectiveEquipmentSelectionInformation =
                protectiveEquipmentCalculation.createNewProtectiveEquipmentSelectionInformation(startInformationId,activePower, cosf);

        protectiveEquipmentSelectionRepository.save(newProtectiveEquipmentSelectionInformation);
    }

    public ProtectiveEquipmentResponseDTO updateProtectiveEquipment(short id, float nominalCurrentOfThermalRelease, float nominalCurrentOfElectromagneticRelease,
                                                                    float nominalCurrentOfCircuitBreaker, String typeOfCircuitBreaker, String cableType) {
        deleteProtectiveEquipmentById(id);
        return saveProtectiveEquipment(id, nominalCurrentOfThermalRelease, nominalCurrentOfElectromagneticRelease,
                nominalCurrentOfCircuitBreaker, typeOfCircuitBreaker, cableType);
    }


    public ProtectiveEquipmentResponseDTO deleteProtectiveEquipmentById(short protectiveEquipmentId) {

        if (protectiveEquipmentRepository.existsById(protectiveEquipmentId)){
            protectiveEquipmentRepository.deleteById(protectiveEquipmentId);
        }else {
            throw new InformationNotFoundException("Unable to find information about the protected equipment. Check the availability of this equipment.");
        }
        return new ProtectiveEquipmentResponseDTO(getAllProtectiveEquipment(),
                getAllProtectiveEquipmentSelectionInformation());
    }

    public void deleteProtectiveEquipmentInformationById(short protectiveEquipmentId) {
        if (protectiveEquipmentSelectionRepository.existsById(protectiveEquipmentId)){
            protectiveEquipmentSelectionRepository.deleteById(protectiveEquipmentId);
        }
    }

    public ProtectiveEquipment getProtectiveEquipmentById(short protectiveEquipmentId) {
        return protectiveEquipmentRepository.findById(protectiveEquipmentId)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about the protected equipment. Check the availability of this equipment."));
    }



    public List<ProtectiveEquipment> getAllProtectiveEquipment() {
        return protectiveEquipmentRepository.findAll();
    }

    public List<ProtectiveEquipmentSelection> getAllProtectiveEquipmentSelectionInformation() {
        return protectiveEquipmentSelectionRepository.findAll();
    }

    public Boolean isAvailable(short protectiveEquipmentSelectionId) {
        return protectiveEquipmentRepository.existsById(protectiveEquipmentSelectionId);
    }
}
