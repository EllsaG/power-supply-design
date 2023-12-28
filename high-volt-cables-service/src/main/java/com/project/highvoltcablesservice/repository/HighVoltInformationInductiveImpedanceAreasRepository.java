package com.project.highvoltcablesservice.repository;

import com.project.highvoltcablesservice.entity.HighVoltInformationInductiveImpedanceAreas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HighVoltInformationInductiveImpedanceAreasRepository
        extends JpaRepository <HighVoltInformationInductiveImpedanceAreas, Short>{

     boolean existsByHighVoltInformationIdFk(short highVoltInformationIds);
     void deleteAllByHighVoltInformationIdFk(short highVoltInformationIdFk);
     List<HighVoltInformationInductiveImpedanceAreas> findByHighVoltInformationIdFk(short highVoltInformationIdFk);
}
