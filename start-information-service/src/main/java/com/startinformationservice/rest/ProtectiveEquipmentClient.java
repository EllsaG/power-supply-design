package com.startinformationservice.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@FeignClient(name = "protective-equipment-service")
public interface ProtectiveEquipmentClient {
    @RequestMapping(value = "protectiveEquipment/{saveProtectiveEquipmentSelectionInformation}", method = RequestMethod.PUT)
    void saveProtectiveEquipmentSelectionInformation(@PathVariable("saveProtectiveEquipmentSelectionInformation") short startInformationId,
                                                     ProtectiveEquipmentRequestDTO protectiveEquipmentRequestDTO);



}
