package com.highvoltcablesservice.repository;

import com.highvoltcablesservice.entity.InductiveImpedanceAreas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InductiveImpedanceAreasRepository extends JpaRepository<InductiveImpedanceAreas,Short> {
}
