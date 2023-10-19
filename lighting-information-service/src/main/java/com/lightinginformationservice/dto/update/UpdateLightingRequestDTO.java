package com.lightinginformationservice.dto.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UpdateLightingRequestDTO {
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
