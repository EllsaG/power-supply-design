package com.project.highvoltcablesservice.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "high_volt_cable_selection")
public class HighVoltCablesSelection {

    @Id
    @Column(name = "high_volt_cable_selection_id")
    private short highVoltCableSelectionId;
    @Column(name = "min_cable_section_for_select")
    private float minCableSectionForSelect;

}