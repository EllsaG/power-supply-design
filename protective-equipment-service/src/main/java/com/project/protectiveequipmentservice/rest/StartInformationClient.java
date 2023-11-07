package com.project.protectiveequipmentservice.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "start-information-service")
public interface StartInformationClient {
    @RequestMapping(value = "startInformation/{checkStartInformationId}", method = RequestMethod.GET)
    Boolean checkAvailability(@PathVariable("checkStartInformationId") short startInformationId);


}
