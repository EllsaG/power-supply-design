package com.protectiveequipmentservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ProtectiveEquipmentSelectionInformationRequestDTO {

    @JsonProperty("startInformationId")
    private short startInformationId;
    @JsonProperty("activePower")
    private float activePower;
    @JsonProperty("cosf")
    private float cosf;
}
