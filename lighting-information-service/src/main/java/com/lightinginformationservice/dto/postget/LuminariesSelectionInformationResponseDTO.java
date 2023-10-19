package com.lightinginformationservice.dto.postget;

import com.lightinginformationservice.dto.LightFluxAtAmountOfLamps;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LuminariesSelectionInformationResponseDTO {

    List<LightFluxAtAmountOfLamps> lightFluxAtAmountOfLampsList;

}
