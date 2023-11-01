package com.highvoltcablesservice.controller.dto;

import com.highvoltcablesservice.entity.HighVoltCablesSelection;
import com.highvoltcablesservice.entity.HighVoltInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class HighVoltInformationResponseDTO {
    List<HighVoltInformation> highVoltInformationList;
    List<HighVoltCablesSelection> highVoltCableSelectionList;
}
