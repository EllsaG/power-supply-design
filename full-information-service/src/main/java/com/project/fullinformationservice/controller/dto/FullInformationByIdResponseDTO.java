package com.project.fullinformationservice.controller.dto;


import com.project.fullinformationservice.entity.FullInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FullInformationByIdResponseDTO {

    FullInformation fullInformation;
}
