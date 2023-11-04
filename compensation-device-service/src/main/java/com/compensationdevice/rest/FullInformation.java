package com.compensationdevice.rest;

import lombok.Getter;

@Getter
public class FullInformation {
    private short fullInformationId;
    private String busbarName;
    private short amount;
    private float avgDailyActivePower;
    private float avgDailyReactivePower;
    private short effectiveAmountOfEquipment;
    private float coefficientMax;
    private float maxActivePower;
    private float maxReactivePower;
    private float maxFullPower;
    private float maxElectricCurrent;
    private float activePower;
    private float cosF;
    private float tgF;
    private float ki;
    private float module;
}
