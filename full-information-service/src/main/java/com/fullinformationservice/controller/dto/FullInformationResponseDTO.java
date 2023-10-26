package com.fullinformationservice.controller.dto;


import com.fullinformationservice.entity.FullInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class FullInformationResponseDTO {

    private List<FullInformation> fullInformationList;

}
