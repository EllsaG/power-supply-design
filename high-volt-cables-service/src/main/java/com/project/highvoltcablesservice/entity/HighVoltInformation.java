package com.project.highvoltcablesservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "high_volt_information")
public class HighVoltInformation {

    @Id
    @Column(name = "high_volt_information_id")
    private short highVoltInformationId;
    @Column(name = "high_voltage_air_line_inductive_resistance")
    private float highVoltageAirLineInductiveResistance;
    @Column(name = "high_voltage_cable_line_inductive_resistance")
    private float highVoltageCableLineInductiveResistance;
    @Column(name = "high_voltage_cable_line_active_resistance")
    private float highVoltageCableLineActiveResistance;
    @Column(name = "surge_coefficient")
    private float surgeCoefficient;
    @Column(name = "economic_current_density")
    private float economicCurrentDensity;
    @Column(name = "short_circuit_time")
    private float shortCircuitTime;
    @Column(name = "coefficient_taking_emitted_heat_difference")
    private float coefficientTakingEmittedHeatDifference ;
    @Column(name = "production_hall_transformer_full_power")
    private float productionHallTransformerFullPower;
    @Column(name = "base_voltage")
    private short baseVoltage;
    @Column(name = "base_full_power")
    private short baseFullPower;
    @Column(name = "relative_baseline_unrestricted_power_resistance")
    private float relativeBaselineUnrestrictedPowerResistance;
    @Column(name = "high_voltage_air_line_length")
    private float highVoltageAirLineLength;
    @Column(name = "head_transformer_full_power")
    private float headTransformerFullPower;
    @Column(name = "short_circuit_voltage")
    private float shortCircuitVoltage;
    @Column(name = "cable_line_length")
    private float cableLineLength;
    @Column(name = "rated_voltage_of_higher_voltage_winding_of_transformer")
    private float ratedVoltageOfHigherVoltageWindingOfTransformer;
    @Column(name = "relative_basis_resistance")
    private float relativeBasisResistance;
    @Column(name = "power_line_relative_resistance")
    private float powerLineRelativeResistance;
    @Column(name = "first_transformer_relative_reactive_resistance")
    private float firstTransformerRelativeReactiveResistance;
    @Column(name = "cable_line_relative_reactive_resistance")
    private float cableLineRelativeReactiveResistance;
    @Column(name = "second_transformer_relative_reactive_resistance")
    private float secondTransformerRelativeReactiveResistance;
    @Column(name = "reactive_resistance_at_point_k_1")
    private float reactiveResistanceAtPointK1;
    @Column(name = "base_current_at_point_k_1")
    private float baseCurrentAtPointK1;
    @Column(name = "full_resistance_at_point_k_1")
    private float fullResistanceAtPointK1;
    @Column(name = "short_circuit_current_at_point_k_1")
    private float shortCircuitCurrentAtPointK1;
    @Column(name = "surge_current_at_point_k_1")
    private float surgeCurrentAtPointK1;
    @Column(name = "short_circuit_power_at_point_k_1")
    private float shortCircuitPowerAtPointK1;
    @Column(name = "rated_power_transformer_current")
    private float ratedPowerTransformerCurrent;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InductiveImpedanceAreas> inductive_impedance_areas_id_fk;
}
