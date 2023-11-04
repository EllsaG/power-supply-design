package com.powertransformerservice.controller.dto;

import com.powertransformerservice.entity.PowerTransformers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PowerTransformerByIdResponseDTO {
    PowerTransformers powerTransformers;
}
