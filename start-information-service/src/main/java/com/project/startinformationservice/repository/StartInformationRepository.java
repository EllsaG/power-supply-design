package com.project.startinformationservice.repository;

import com.project.startinformationservice.entity.StartInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StartInformationRepository extends JpaRepository<StartInformation,Short> {
}
