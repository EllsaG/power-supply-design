package com.project.highvoltcablesservice.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "high_volt_information_inductive_impedance_areas")
public class HighVoltInformationInductiveImpedanceAreas {

    @Id
    @Column(name = "high_volt_information_inductive_impedance_areas_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private short highVoltInformationInductiveImpedanceAreasId;

    @Column(name = "high_volt_information_id_fk")
    private Short highVoltInformationIdFk;

    @Column(name = "inductive_impedance_areas_id_fk")
    private Short inductiveImpedanceAreasIdFk;

    public HighVoltInformationInductiveImpedanceAreas(Short highVoltInformationIdFk, Short inductiveImpedanceAreasIdFk) {
        this.highVoltInformationIdFk = highVoltInformationIdFk;
        this.inductiveImpedanceAreasIdFk = inductiveImpedanceAreasIdFk;
    }
}
