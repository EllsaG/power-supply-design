package com.project.highvoltcablesservice.repository;

import com.project.highvoltcablesservice.entity.HighVoltCables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HighVoltCablesRepository extends JpaRepository<HighVoltCables,Short> {
}
