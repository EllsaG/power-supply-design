package com.protectiveequipmentservice.repository;

import com.protectiveequipmentservice.entity.LowVoltCables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LowVoltCablesRepository extends JpaRepository<LowVoltCables,Short> {
}
