package com.project.protectiveequipmentservice.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "low_volt_cables")
public class LowVoltCables {

    @Id
    @Column(name = "low_volt_cables_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private short lowVoltCablesId;
    @Column(name = "cable_type")
    @Setter
    private String cableType;

    public LowVoltCables(String cableType) {
        this.cableType = cableType;
    }
}
