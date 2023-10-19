package com.fullinformationservice.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "full_information")
public class FullInformation {
    @Id
    @Column(name = "full_information_id")
    private short fullInformationId;
    @Column(name = "busbar_name")
    private String busbarName;
    @Column(name = "amount")
    private short amount;
    @Column(name = "avg_daily_active_power")
    private float avgDailyActivePower;
    @Column(name = "avg_daily_reactive_power")
    private float avgDailyReactivePower;
    @Column(name = "effective_amount_of_equipment")
    private short effectiveAmountOfEquipment;
    @Column(name = "coefficient_max")
    private float coefficientMax;
    @Column(name = "max_active_power")
    private float maxActivePower;
    @Column(name = "max_reactive_power")
    private float maxReactivePower;
    @Column(name = "max_full_power")
    private float maxFullPower;
    @Column(name = "max_electric_current")
    private float maxElectricCurrent;
    @Column(name = "power_of_group")
    private float activePower;
    @Column(name = "cos_f")
    private float cosF;
    @Column(name = "tg_f")
    private float tgF;
    @Column(name = "k_i")
    private float ki;
    @Column(name = "module")
    private float module;
}
