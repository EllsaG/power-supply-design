package com.startinformationservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class StartInformationRequestDTO {
    @JsonProperty("startInformId")
    private short startInformId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("power")
    private float power;
    @JsonProperty("amount")
    private short amount;
    @JsonProperty("ki")
    private float ki;
    @JsonProperty("cosf")
    private float cosf;
    @JsonProperty("tgf")
    private float tgf;

}
