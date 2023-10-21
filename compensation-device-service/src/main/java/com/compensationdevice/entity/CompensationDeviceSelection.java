package com.compensationdevice.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "compensation_device_selection")
public class CompensationDeviceSelection {
    @Id
    @Column(name ="compensation_device_selection_id")
    private short compensationDeviceSelectionId;
    @Column(name = "min_power_of_compensation_device")
    private float minPowerOfCompensatingDevice;
    @Column(name = "max_power_of_compensation_device")
    private float maxPowerOfCompensatingDevice;



}