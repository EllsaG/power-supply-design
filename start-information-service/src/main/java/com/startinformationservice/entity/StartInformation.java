package com.startinformationservice.entity;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "start_information")
public class StartInformation {

    @Id
    @Column(name = "start_information_id")
    private short startInformationId;
    @Column(name = "name")
    private String name;
    @Column(name = "power")
    private float power;
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
}
