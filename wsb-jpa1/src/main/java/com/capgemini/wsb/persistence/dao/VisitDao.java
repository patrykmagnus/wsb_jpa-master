package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;
import java.util.Optional;

public interface VisitDao extends Dao<VisitEntity, Long> {
    List<VisitEntity> findByPatientId(Long patientId);

    Optional<VisitEntity> findById(Long id);
}
