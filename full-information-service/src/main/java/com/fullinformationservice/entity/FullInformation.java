package com.fullinformationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "full_information")
public class FullInformation {
    @Id
    @Column(name = "full_information_id")
    private long fullInformationId;
    @Column(name = "busbar_name")
    private String busbarName;
    @Column(name = "amount")
    private int amount;
    @Column(name = "avg_daily_active_power")
    private double avgDailyActivePower;
    @Column(name = "avg_daily_reactive_power")
    private double avgDailyReactivePower;
    @Column(name = "effective_amount_of_equipment")
    private int effectiveAmountOfEquipment;
    @Column(name = "coefficient_max")
    private double coefficientMax;
    @Column(name = "max_active_power")
    private double maxActivePower;
    @Column(name = "max_reactive_power")
    private double maxReactivePower;
    @Column(name = "max_full_power")
    private double maxFullPower;
    @Column(name = "max_electric_current")
    private double maxElectricCurrent;
    @Column(name = "power_of_group")
    private double powerOfGroup;
    @Column(name = "cos_f")
    private double cosF;
    @Column(name = "tg_f")
    private double tgF;
    @Column(name = "k_i")
    private double ki;
    @Column(name = "module")
    private double module;
}
