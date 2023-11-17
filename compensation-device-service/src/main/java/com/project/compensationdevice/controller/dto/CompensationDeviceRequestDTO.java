package com.project.compensationdevice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompensationDeviceRequestDTO {
    @JsonProperty("compensationDeviceId")
    short compensationDeviceId;
    @JsonProperty("nameOfCompensationDevice")
    String nameOfCompensationDevice;
    @JsonProperty("reactivePowerOfCompensationDevice")
    float reactivePowerOfCompensationDevice;

}
