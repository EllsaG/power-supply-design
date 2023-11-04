package com.lightinginformationservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LightFluxAtAmountOfLamps {
    @JsonProperty("lightingInformationId")
    short lightingInformationId;
    @JsonProperty("amountOfLampsInOneLuminaire")
    short amountOfLampsInOneLuminaire;
    @JsonProperty("minLightFluxForLuminaireSelection")
    float minLightFluxForLuminaireSelection;
    @JsonProperty("maxLightFluxForLuminaireSelection")
    float maxLightFluxForLuminaireSelection;
}
