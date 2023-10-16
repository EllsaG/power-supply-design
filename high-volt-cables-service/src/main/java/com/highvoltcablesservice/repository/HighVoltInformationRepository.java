package com.highvoltcablesservice.repository;

import com.highvoltcablesservice.entity.HighVoltInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HighVoltInformationRepository extends JpaRepository<HighVoltInformation,Short> {
}
