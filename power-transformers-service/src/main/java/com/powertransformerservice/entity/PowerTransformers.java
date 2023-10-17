package com.powertransformerservice.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "power_transformers")
public class PowerTransformers {

    @Id
    @Column(name = "power_transformers_id")
    private short powerTransformersId;
    @Column(name = "transformer_model")
    private String transformerModel;
    @Column(name = "transformer_full_power")
    private float transformerFullPower;
    @Column(name = "transformer_load_coef")
    private float transformerLoadCoef;
    @Column(name = "short_circuit_voltage")
    private float shortCircuitVoltage;
    @Column(name = "transformer_idle_losses")
    private float transformerIdleLosses;
    @Column(name = "high_side_voltage")
    private float highSideVoltage;
    @Column(name = "low_side_voltage")
    private float lowSideVoltage;
    @Column(name = "short_circuit_losses")
    private float shortCircuitLosses;
    @Column(name = "idle_current")
    private float idleCurrent;

}
