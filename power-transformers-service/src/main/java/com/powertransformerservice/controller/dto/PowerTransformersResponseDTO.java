package com.powertransformerservice.controller.dto;


import com.powertransformerservice.entity.PowerTransformers;
import com.powertransformerservice.entity.TransformerSelection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class PowerTransformersResponseDTO {

    List<PowerTransformers> powerTransformersList;
    List <TransformerSelection> transformerSelectionList;

}
