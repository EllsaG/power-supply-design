package com.protectiveequipmentservice.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "protective_equipment")
public class ProtectiveEquipment {
    @Id
    @Column(name = "protective_equipment_id")
    private short protectiveEquipmentId;
    @Column(name = "circuit_breaker_type")
    private String circuitBreakerType;
    @Column(name = "thermal_release_rated_current")
    private float thermalReleaseRatedCurrent;
    @Column(name = "electromagnetic_release_rated_current")
    private float electromagneticReleaseRatedCurrent;
    @Column(name = "circuit_breaker_rated_current")
    private float circuitBreakerRatedCurrent;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private LowVoltCables low_volt_cables_id_fk;

}
