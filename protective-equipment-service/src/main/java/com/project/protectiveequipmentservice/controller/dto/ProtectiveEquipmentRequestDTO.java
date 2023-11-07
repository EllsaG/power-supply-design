package com.project.protectiveequipmentservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ProtectiveEquipmentRequestDTO {

    @JsonProperty("protectiveEquipmentId")
    private short protectiveEquipmentId;
    @JsonProperty("circuitBreakerType")
    private String circuitBreakerType;
    @JsonProperty("thermalReleaseRatedCurrent")
    private float thermalReleaseRatedCurrent;
    @JsonProperty("electromagneticReleaseRatedCurrent")
    private float electromagneticReleaseRatedCurrent;
    @JsonProperty("circuitBreakerRatedCurrent")
    private float circuitBreakerRatedCurrent;
    @JsonProperty("cableType")
    private String cableType;
}
