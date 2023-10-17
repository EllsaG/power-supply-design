package com.highvoltcablesservice.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "high_volt_cables")
public class HighVoltCables {

    @Id
    @Column(name = "high_volt_cables_id")
    private short highVoltCablesId;
    @Column(name = "cable_type")
    private String cableType;

}
