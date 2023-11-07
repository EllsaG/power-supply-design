package com.project.highvoltcablesservice.controller.dto;

import com.project.highvoltcablesservice.entity.HighVoltCables;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class HighVoltCablesResponseDTO {
    List<HighVoltCables> highVoltCablesList;
}
