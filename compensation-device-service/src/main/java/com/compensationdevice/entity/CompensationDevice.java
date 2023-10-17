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
@Table(name = "compensation_device")
public class CompensationDevice {
    @Id
    @Column(name = "compensation_device_id")
    private long compensationDeviceId;
    @Column(name = "model_of_compensation_device")
    private String modelOfCompensationDevice;
    @Column(name = "reactive_power_of_compensation_device")
    private double reactivePowerOfCompensationDevice;

}