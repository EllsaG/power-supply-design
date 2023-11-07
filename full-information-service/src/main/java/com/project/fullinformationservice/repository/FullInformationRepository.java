package com.project.fullinformationservice.repository;


import com.project.fullinformationservice.entity.FullInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullInformationRepository extends JpaRepository<FullInformation,Short> {

}
