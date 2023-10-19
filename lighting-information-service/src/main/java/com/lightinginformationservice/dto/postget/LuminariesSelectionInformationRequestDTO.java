package com.lightinginformationservice.dto.postget;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LuminariesSelectionInformationRequestDTO {
    @JsonProperty("lightingId")
    private long lightingId;
    @JsonProperty("heightProductionHall")
    private double heightProductionHall;
    @JsonProperty("widthProductionHall")
    private double widthProductionHall;
    @JsonProperty("lengthProductionHall")
    private double lengthProductionHall;
}
