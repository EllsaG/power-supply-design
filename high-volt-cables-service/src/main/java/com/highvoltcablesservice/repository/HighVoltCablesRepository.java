package com.highvoltcablesservice.repository;

import com.highvoltcablesservice.entity.HighVoltCables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HighVoltCablesRepository extends JpaRepository<HighVoltCables,Short> {
}
