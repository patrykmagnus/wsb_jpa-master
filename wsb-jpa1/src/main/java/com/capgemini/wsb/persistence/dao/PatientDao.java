package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;
import java.util.Optional;

public interface PatientDao extends Dao<PatientEntity, Long> {
    Optional<PatientEntity> findById(Long id);

    List<PatientEntity> findByLastName(String lastName);

    List<PatientEntity> findByVisitCountGreaterThan(int visitCount);

    List<PatientEntity> findByAgeGreaterThan(int age); // Assuming 'age' is the additional field
}
