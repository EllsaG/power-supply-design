package com.fullinformationservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class FullStartInformIdRequestDTO {

    @JsonProperty("numberOfBusbar")
    private short numberOfBusbar;
    @JsonProperty("numbersOfEquipment")
    private short numberOfEquipment;
    @JsonProperty("amountOfEquipments")
    private short amountOfEquipment;


}
