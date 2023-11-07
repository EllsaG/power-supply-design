package com.project.lightinginformationservice.entity;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name="light_information")
public class LightInformation {
    @Id
    @Column(name="light_information_id")
    private short lightInformationId;

    @Column(name="luminaire_model")
    private String luminaireModel;
    @Column(name="lamp_model")
    private String lampModel;
    @Column(name="amount_luminaires")
    private short amountLuminaires;
    @Column(name="amount_lamps_in_one_luminaire")
    private short amountLampsInOneLuminaire;
    @Column(name="one_lamp_power")
    private float oneLampPower;
    @Column(name="one_lamp_light_flux")
    private float oneLampLightFlux;
    @Column(name="distance_between_lamp_rows")
    private float distanceBetweenLampRows;
    @Column(name="distance_between_wall_and_first_lamp_row")
    private float distanceBetweenWallAndFirstLampRow;
    @Column(name="amount_luminaires_per_length")
    private short amountLuminairesPerLength;
    @Column(name="amount_luminaires_per_width")
    private short amountLuminairesPerWidth;
    @Column(name="total_active_power")
    private float totalActivePower;
    @Column(name="total_reactive_power")
    private float totalReactivePower;
    @Column(name="total_full_power")
    private float totalFullPower;
    @Column(name="electric_current")
    private float electricCurrent;
    @Column(name="electric_current_of_one_row_of_luminaires")
    private float electricCurrentOfOneRowOfLuminaires;
    @Column(name = "cos_f")
    private float cosF;
    @Column(name = "tg_f")
    private float tgF;


}
