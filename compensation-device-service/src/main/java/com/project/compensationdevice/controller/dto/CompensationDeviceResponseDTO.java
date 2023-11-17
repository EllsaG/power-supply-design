package com.project.compensationdevice.controller.dto;


import com.project.compensationdevice.entity.CompensationDevice;
import com.project.compensationdevice.entity.CompensationDeviceSelection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompensationDeviceResponseDTO {
    List<CompensationDevice> compensationDeviceList;
    List<CompensationDeviceSelection> compensationDeviceSelectionList;



}
