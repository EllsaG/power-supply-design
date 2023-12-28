package com.project.highvoltcablesservice.controller.dto;


import com.project.highvoltcablesservice.entity.HighVoltCablesSelection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HighVoltCablesSelectionInformationResponseDTO {
    List<HighVoltCablesSelection> highVoltCablesSelectionList;
}
