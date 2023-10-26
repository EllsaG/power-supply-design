package com.fullinformationservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
@Getter
public class FullInformationRequestDTO {
    @JsonProperty("fullInformationId")
    private short fullInformationId;
    @JsonProperty("nameOfBusbar")
    private String nameOfBusbar;
    @JsonProperty("numbersAndAmountOfEquipments")
    private List <FullStartInformIdRequestDTO> fullStartInformId;

}
