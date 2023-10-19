package com.lightinginformationservice.dto.postget;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateNewLightingRequestDTO {
    @JsonProperty("lightingId")
    private long lightingId;
    @JsonProperty("modelOfLuminaire")
    private String modelOfLuminaire;
    @JsonProperty("modelOfLamp")
    private String modelOfLamp;
    @JsonProperty("amountOfLampsInOneLuminaire")
    private int amountOfLampsInOneLuminaire;
    @JsonProperty("lightFluxOneLamp")
    private double lightFluxOneLamp;
    @JsonProperty("activePowerOneLamp")
    private double activePowerOneLamp;
}
