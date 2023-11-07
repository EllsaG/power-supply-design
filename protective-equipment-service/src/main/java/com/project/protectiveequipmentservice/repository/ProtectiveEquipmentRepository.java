package com.project.protectiveequipmentservice.repository;

import com.project.protectiveequipmentservice.entity.ProtectiveEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtectiveEquipmentRepository extends JpaRepository<ProtectiveEquipment,Short> {
}
