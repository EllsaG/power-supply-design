package com.fullinformationservice.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "start-information-service")
public interface StartInformationServiceClient {

    @RequestMapping(value = "startInformation/{startInformationId}", method = RequestMethod.GET)
    StartInformationResponseDTO getStartInformationById(@PathVariable("startInformationId") short startInformationId);

}
