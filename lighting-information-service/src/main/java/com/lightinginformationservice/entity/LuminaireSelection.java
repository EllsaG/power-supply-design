package com.lightinginformationservice.entity;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "luminaire_selection")
public class LuminaireSelection {

    @Id
    @Column(name = "luminaire_selection_id")
    private short luminaireSelectionId;
    @Column(name = "distance_between_lamp_rows")
    private float distanceBetweenLampRows;
    @Column(name = "distance_between_wall_and_first_lamp_row")
    private float distanceBetweenWallAndFirstLampRow;
    @Column(name = "amount_luminaires_per_length")
    private short amountLuminairesPerLength;
    @Column(name = "amount_luminaires_per_width")
    private short amountLuminairesPerWidth;
    @Column(name = "light_flux")
    private float lightFlux;
    @Column(name = "production_hall_height")
    private float productionHallHeight;
    @Column(name = "production_hall_width")
    private float productionHallWidth;
    @Column(name = "production_hall_length")
    private float productionHallLength;

}
