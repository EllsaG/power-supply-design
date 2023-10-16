package com.highvoltcablesservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "high_volt_cables")
public class HighVoltCables {

    @Id
    @Column(name = "high_volt_cables_id")
    private short highVoltCablesId;
    @Column(name = "cable_type")
    private String cableType;

}
