package com.project.compensationdevice.repository;

import com.project.compensationdevice.entity.CompensationDeviceSelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompensationDeviceSelectionRepository extends JpaRepository<CompensationDeviceSelection,Short> {
}
