package com.project.highvoltcablesservice.repository;

import com.project.highvoltcablesservice.entity.HighVoltCablesSelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HighVoltCablesSelectionRepository extends JpaRepository<HighVoltCablesSelection,Short> {
}
