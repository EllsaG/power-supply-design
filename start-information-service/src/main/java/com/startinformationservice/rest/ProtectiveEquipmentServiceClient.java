package com.startinformationservice.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "protective-equipment-service")
public interface ProtectiveEquipmentServiceClient {
    @RequestMapping(value = "protectiveEquipment/{saveProtectiveEquipmentSelectionInformation}", method = RequestMethod.PUT)
    void saveProtectiveEquipmentSelectionInformation(@PathVariable("saveProtectiveEquipmentSelectionInformation")
                                                     ProtectiveEquipmentRequestDTO protectiveEquipmentRequestDTO);
    @RequestMapping(value = "protectiveEquipment/{deleteProtectiveEquipmentSelectionInformation}", method = RequestMethod.PUT)
    void deleteProtectiveEquipmentSelectionInformationById(@PathVariable("deleteProtectiveEquipmentSelectionInformation") short protectiveEquipmentSelectionId);
    @RequestMapping(value = "protectiveEquipment/{checkProtectiveEquipmentSelectionInformation}", method = RequestMethod.GET)
    Boolean checkAvailability(@PathVariable("checkProtectiveEquipmentSelectionInformation") short protectiveEquipmentSelectionId);

}
