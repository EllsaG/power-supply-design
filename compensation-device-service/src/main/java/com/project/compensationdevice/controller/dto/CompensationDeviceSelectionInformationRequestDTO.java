package com.project.compensationdevice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CompensationDeviceSelectionInformationRequestDTO {
    @JsonProperty("compensationDeviceSelectionId")
    private short compensationDeviceSelectionId;
    @JsonProperty("avgDailyActivePower")
    private float avgDailyActivePower;
    @JsonProperty("tgfBeforeCompensation")
    private float tgfBeforeCompensation;
}
