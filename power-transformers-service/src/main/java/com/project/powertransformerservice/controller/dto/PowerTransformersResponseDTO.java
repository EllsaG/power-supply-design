package com.project.powertransformerservice.controller.dto;


import com.project.powertransformerservice.entity.PowerTransformers;
import com.project.powertransformerservice.entity.TransformerSelection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PowerTransformersResponseDTO {

    List<PowerTransformers> powerTransformersList;
    List <TransformerSelection> transformerSelectionList;

}
