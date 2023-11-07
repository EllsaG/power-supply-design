package com.project.protectiveequipmentservice.calculation;


import com.project.protectiveequipmentservice.entity.LowVoltCables;
import com.project.protectiveequipmentservice.entity.ProtectiveEquipment;
import com.project.protectiveequipmentservice.entity.ProtectiveEquipmentSelection;
import com.project.protectiveequipmentservice.exeptions.InformationNotFoundException;
import com.project.protectiveequipmentservice.repository.ProtectiveEquipmentSelectionRepository;
import com.project.protectiveequipmentservice.rest.StartInformationClient;

public class ProtectiveEquipmentCalculation {


    public ProtectiveEquipmentSelection createNewProtectiveEquipmentSelectionInformation(short startInformationId,
                                                                                         float activePower, float cosf) {
        final float efficiencyFactor = 0.87F; // depends on type of equipment
        final float voltage = 0.38F;
        final float coefIncreasingInrushCurrent = 5; // depends on type of equipment

        float nominalCurrentOfEquipment = Math.round(activePower /
                        (Math.sqrt(3) * voltage * cosf * efficiencyFactor) * 100) / 100.0F;
        float startingCurrentOfEquipment = Math.round(nominalCurrentOfEquipment * coefIncreasingInrushCurrent * 100)/100.0F;
        float calculatedCurrentOfThermalRelease = Math.round(1.15 * nominalCurrentOfEquipment * 100)/100.0F;
        float calculatedCurrentOfElectromagneticRelease = Math.round(1.25 * startingCurrentOfEquipment * 100)/100.0F;

        return new ProtectiveEquipmentSelection(startInformationId,nominalCurrentOfEquipment, startingCurrentOfEquipment,
                calculatedCurrentOfThermalRelease, calculatedCurrentOfElectromagneticRelease);
    }


    public ProtectiveEquipment createNewProtectiveEquipment(short id, float nominalCurrentOfThermalRelease, float nominalCurrentOfElectromagneticRelease,
                                                            float nominalCurrentOfCircuitBreaker, String typeOfCircuitBreaker, String cableType, StartInformationClient startInformationClient,
                                                            ProtectiveEquipmentSelectionRepository protectiveEquipmentSelectionRepository) {

        if (!startInformationClient.checkAvailability(id)){
            throw new InformationNotFoundException("Unable to find information about the protected equipment. Check the availability of this equipment.");
        }

        protectiveEquipmentSelectionRepository.findById(id)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about the protected equipment. Check the availability of this equipment."));

        return new ProtectiveEquipment(id, typeOfCircuitBreaker, nominalCurrentOfThermalRelease, nominalCurrentOfElectromagneticRelease,
                nominalCurrentOfCircuitBreaker, new LowVoltCables(cableType));
    }


}
