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
    private long fullStartInformationId;

    @Column(name = "full_information_id")
    private long fullInformationId;
    @Column(name = "start_information_id")
    private long startInformationId;
    @Column(name = "name")
    private String name;
    @Column(name = "power")
    private double power;
    @Column(name = "power_of_group")
    private double powerOfGroup;
    @Column(name = "amount")
    private int amount;
    @Column(name = "k_i")
    private double ki;
    @Column(name = "cos_f")
    private double cosf;
    @Column(name = "tg_f")
    private double tgf;
    @Column(name = "avg_daily_active_power")
    private double avgDailyActivePower;
    @Column(name = "avg_daily_reactive_power")
    private double avgDailyReactivePower;

    public FullStartInformation(long fullInformationId, long startInformationId, int amount) {
        this.fullInformationId = fullInformationId;
        this.startInformationId = startInformationId;
        this.amount = amount;
    }

    public FullStartInformation(long fullInformationId, long startInformationId, String name, double power,
                             double powerOfGroup, int amount, double ki, double cosf, double tgf,
                             double avgDailyActivePower, double avgDailyReactivePower) {
        this.fullInformationId = fullInformationId;
        this.startInformationId = startInformationId;
        this.name = name;
        this.power = power;
        this.powerOfGroup = powerOfGroup;
        this.amount = amount;
        this.ki = ki;
        this.cosf = cosf;
        this.tgf = tgf;
        this.avgDailyActivePower = avgDailyActivePower;
        this.avgDailyReactivePower = avgDailyReactivePower;
    }

}
