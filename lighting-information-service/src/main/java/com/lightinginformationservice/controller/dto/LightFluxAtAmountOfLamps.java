package com.lightinginformationservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LightFluxAtAmountOfLamps {
    short lightingInformationId;
    short amountOfLampsInOneLuminaire;
    float minLightFluxForChooseLuminaire;
    float maxLightFluxForChooseLuminaire;
}
