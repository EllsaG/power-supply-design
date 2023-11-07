package com.project.highvoltcablesservice.rest;


import lombok.Getter;

@Getter
public class PowerTransformers {
    private short powerTransformersId;
    private String transformerModel;
    private float transformerFullPower;
    private float transformerLoadCoef;
    private float shortCircuitVoltage;
    private float transformerIdleLosses;
    private float highSideVoltage;
    private float lowSideVoltage;
    private float shortCircuitLosses;
    private float idleCurrent;
}
