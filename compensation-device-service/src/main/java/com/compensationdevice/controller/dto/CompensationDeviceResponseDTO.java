package com.compensationdevice.controller.dto;


import com.compensationdevice.entity.CompensationDevice;
import com.compensationdevice.entity.CompensationDeviceSelection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class CompensationDeviceResponseDTO {
    List<CompensationDevice> compensationDeviceList;
    List<CompensationDeviceSelection> compensationDeviceSelectionList;



}
