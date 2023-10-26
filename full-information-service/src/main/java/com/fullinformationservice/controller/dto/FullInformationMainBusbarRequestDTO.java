package com.fullinformationservice.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
@Getter
public class FullInformationMainBusbarRequestDTO {

    @JsonProperty("fullInformationId")
    private short fullInformationId;
    @JsonProperty("busbarName")
    private String busbarName;
    @JsonProperty("numbersBusbarsIncludedInMain")
    private List<Short> numbersBusbarsIncludedInMain;

}
