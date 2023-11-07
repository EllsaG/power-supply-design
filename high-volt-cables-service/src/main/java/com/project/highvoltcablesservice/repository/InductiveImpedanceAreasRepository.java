package com.project.highvoltcablesservice.repository;

import com.project.highvoltcablesservice.entity.InductiveImpedanceAreas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InductiveImpedanceAreasRepository extends JpaRepository<InductiveImpedanceAreas,Short> {
}
