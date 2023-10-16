package com.highvoltcablesservice.repository;

import com.highvoltcablesservice.entity.HighVoltCablesSelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HighVoltCablesSelectionRepository extends JpaRepository<HighVoltCablesSelection,Short> {
}
