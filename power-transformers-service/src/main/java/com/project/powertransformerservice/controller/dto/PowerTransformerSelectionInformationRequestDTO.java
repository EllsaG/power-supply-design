package com.project.powertransformerservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PowerTransformerSelectionInformationRequestDTO {

    private short powerTransformerSelectionId;
    private float ratedPowerForTransformerSelection;
}
