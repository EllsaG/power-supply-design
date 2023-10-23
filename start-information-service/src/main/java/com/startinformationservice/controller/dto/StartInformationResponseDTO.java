package com.startinformationservice.controller.dto;


import com.startinformationservice.entity.StartInformation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StartInformationResponseDTO {

    private List<StartInformation> startInformationList;

    public StartInformationResponseDTO(List<StartInformation> startInformationList) {
        this.startInformationList = startInformationList;
    }
}
