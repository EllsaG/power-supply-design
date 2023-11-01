package com.highvoltcablesservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class HighVoltCablesSelectionInformationRequestDTO {
    @JsonProperty("highVoltCableSelectionId")
    private short highVoltCableSelectionId;
    @JsonProperty("cableType")
    private String cableType;
}
