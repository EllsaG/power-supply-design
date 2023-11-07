package com.project.lightinginformationservice.repository;

import com.project.lightinginformationservice.entity.LuminaireSelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuminaireSelectionRepository extends JpaRepository<LuminaireSelection,Short> {
}
