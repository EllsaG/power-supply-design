package com.lightinginformationservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LuminaireSelectionRequestDTO {
    @JsonProperty("lightingInformationId")
    private short lightingInformationId;
    @JsonProperty("heightProductionHall")
    private float heightProductionHall;
    @JsonProperty("widthProductionHall")
    private float widthProductionHall;
    @JsonProperty("lengthProductionHall")
    private float lengthProductionHall;
}
