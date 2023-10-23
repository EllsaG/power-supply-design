package com.highvoltcablesservice.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "power-transformers-service")
public interface PowerTransformersServiceClient {

    @RequestMapping(value = "powerTransformers/{powerTransformersId}", method = RequestMethod.GET)
    PowerTransformersResponseDTO getPowerTransformersInformationById(@PathVariable("powerTransformersId") short powerTransformersId);





}