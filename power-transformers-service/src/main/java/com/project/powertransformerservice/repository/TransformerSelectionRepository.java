package com.project.powertransformerservice.repository;

import com.project.powertransformerservice.entity.TransformerSelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransformerSelectionRepository extends JpaRepository<TransformerSelection,Short> {
}
