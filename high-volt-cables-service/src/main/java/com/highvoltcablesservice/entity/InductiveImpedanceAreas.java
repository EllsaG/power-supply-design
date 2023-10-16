package com.highvoltcablesservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "inductive_impedance_areas")
public class InductiveImpedanceAreas {
    @Id
    @Column(name = "inductive_impedance_areas_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private short inductiveImpedanceAreasId;
    @Setter
    @Column(name = "inductive_resistance")
    private float inductiveResistance;

    public InductiveImpedanceAreas(float inductiveResistance) {
        this.inductiveResistance = inductiveResistance;
    }
}
