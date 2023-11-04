package com.fullinformationservice.controller.dto;


import com.fullinformationservice.entity.FullInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FullInformationByIdResponseDTO {

    FullInformation fullInformation;
}
