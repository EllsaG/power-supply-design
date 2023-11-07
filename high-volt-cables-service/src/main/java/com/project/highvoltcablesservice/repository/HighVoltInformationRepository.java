package com.project.highvoltcablesservice.repository;

import com.project.highvoltcablesservice.entity.HighVoltInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HighVoltInformationRepository extends JpaRepository<HighVoltInformation,Short> {
}
