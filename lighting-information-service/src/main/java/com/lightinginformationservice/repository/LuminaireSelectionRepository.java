package com.lightinginformationservice.repository;

import com.lightinginformationservice.entity.LuminaireSelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuminaireSelectionRepository extends JpaRepository<LuminaireSelection,Short> {
}
