package com.project.compensationdevice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CompensationDeviceRequestDTO {
    @JsonProperty("compensationDeviceId")
    short compensationDeviceId;
    @JsonProperty("nameOfCompensationDevice")
    String nameOfCompensationDevice;
    @JsonProperty("reactivePowerOfCompensationDevice")
    float reactivePowerOfCompensationDevice;

}
