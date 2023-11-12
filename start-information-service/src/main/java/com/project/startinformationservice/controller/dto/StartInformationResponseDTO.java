package com.project.startinformationservice.controller.dto;


import com.project.startinformationservice.entity.StartInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StartInformationResponseDTO {

    private List<StartInformation> startInformationList;

}
