package com.compensationdevice.repository;

import com.compensationdevice.entity.CompensationDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompensationDeviceRepository
        extends JpaRepository<CompensationDevice,Short> {
}
