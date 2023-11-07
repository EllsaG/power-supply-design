package com.project.lightinginformationservice.controller.dto;

import com.project.lightinginformationservice.entity.LightInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class LightingInformationResponseDTO {

    List<LightInformation> lightInformationList;
}
