package com.lightinginformationservice.dto.postget;


import com.lightinginformationservice.entity.LightInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CreateNewLightingResponseDTO {

    List<LightInformation> lightInformationList;


}
