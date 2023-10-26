package com.fullinformationservice.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class PowerTransformerSelectionInformationRequestDTO {

    private short powerTransformereSelectionId;
    private float ratedPowerForTransformerSelection;
}
