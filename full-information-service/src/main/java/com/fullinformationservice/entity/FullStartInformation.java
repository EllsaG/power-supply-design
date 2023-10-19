package com.fullinformationservice.entity;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "full_start_information")
public class FullStartInformation {
    @Id
    @Column(name = "full_start_information_id")
    private short fullStartInformationId;

    @Column(name = "full_information_id")
    private short fullInformationId;
    @Column(name = "start_information_id")
    private short startInformationId;
    @Column(name = "name")
    private String name;
    @Column(name = "power")
    private float activePowerOfOne;
    @Column(name = "power_of_group")
    private float activePowerOfGroup;
    @Column(name = "amount")
    private short amount;
    @Column(name = "k_i")
    private float ki;
    @Column(name = "cos_f")
    private float cosf;
    @Column(name = "tg_f")
    private float tgf;
    @Column(name = "avg_daily_active_power")
    private float avgDailyActivePower;
    @Column(name = "avg_daily_reactive_power")
    private float avgDailyReactivePower;

    public FullStartInformation(short fullInformationId, short startInformationId, short amount) {
        this.fullInformationId = fullInformationId;
        this.startInformationId = startInformationId;
        this.amount = amount;
    }

    public FullStartInformation(short fullInformationId, short startInformationId, String name, float activePowerOfOne,
                                float activePowerOfGroup, short amount, float ki, float cosf, float tgf,
                                float avgDailyActivePower, float avgDailyReactivePower) {
        this.fullInformationId = fullInformationId;
        this.startInformationId = startInformationId;
        this.name = name;
        this.activePowerOfOne = activePowerOfOne;
        this.activePowerOfGroup = activePowerOfGroup;
        this.amount = amount;
        this.ki = ki;
        this.cosf = cosf;
        this.tgf = tgf;
        this.avgDailyActivePower = avgDailyActivePower;
        this.avgDailyReactivePower = avgDailyReactivePower;
    }

}
