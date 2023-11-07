package com.project.protectiveequipmentservice.repository;

import com.project.protectiveequipmentservice.entity.ProtectiveEquipmentSelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtectiveEquipmentSelectionRepository extends JpaRepository<ProtectiveEquipmentSelection,Short> {
}
