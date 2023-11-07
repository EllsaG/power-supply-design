package com.project.fullinformationservice.controller.dto;


import com.project.fullinformationservice.entity.FullInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FullInformationByIdResponseDTO {

    FullInformation fullInformation;
}
