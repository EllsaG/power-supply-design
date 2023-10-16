package com.protectiveequipmentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "protective_equipment_selection")
public class ProtectiveEquipmentSelection {

    @Id
    @Column(name = "protective_equipment_selection_id")
    private short protectiveEquipmentSelectionId;
    @Column(name = "equipment_rated_current")
    private float equipmentRatedCurrent;
    @Column(name = "equipment_starting_current")
    private float equipmentStartingCurrent;
    @Column(name = "calculated_current_of_thermal_release")
    private float calculatedCurrentOfThermalRelease;
    @Column(name = "calculated_current_of_electromagnetic_release")
    private float calculatedCurrentOfElectromagneticRelease;

}
