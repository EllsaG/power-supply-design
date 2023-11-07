package com.project.powertransformerservice.controller.dto;

import com.project.powertransformerservice.entity.PowerTransformers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PowerTransformerByIdResponseDTO {
    PowerTransformers powerTransformers;
}
