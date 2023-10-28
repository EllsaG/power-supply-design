package com.lightinginformationservice.repository;

import com.lightinginformationservice.entity.LightInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightingInformationRepository extends JpaRepository<LightInformation,Short> {
}
