package com.fullinformationservice.repository;

import com.fullinformationservice.entity.FullStartInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullStartInformationRepository extends JpaRepository<FullStartInformation,Short> {

     void deleteAllByFullInformationId(short fullInformationId);

}
