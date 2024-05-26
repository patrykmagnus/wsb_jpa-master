package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class VisitDaoImpl extends AbstractDao<VisitEntity, Long> implements VisitDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<VisitEntity> findByPatientId(Long patientId) {
        TypedQuery<VisitEntity> query = entityManager.createQuery(
                "SELECT v FROM VisitEntity v WHERE v.patient.id = :patientId", VisitEntity.class);
        query.setParameter("patientId", patientId);
        return query.getResultList();
    }

    @Override
    public Optional<VisitEntity> findById(Long id) {
        return Optional.ofNullable(entityManager.find(VisitEntity.class, id));
    }
}
