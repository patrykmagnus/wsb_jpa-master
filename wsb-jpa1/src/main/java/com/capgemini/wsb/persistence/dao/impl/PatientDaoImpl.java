package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public Optional<PatientEntity> findById(Long id) {
        return Optional.ofNullable(entityManager.find(PatientEntity.class, id));
    }

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findByVisitCountGreaterThan(int visitCount) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE SIZE(p.visits) > :visitCount", PatientEntity.class);
        query.setParameter("visitCount", visitCount);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findByAgeGreaterThan(int age) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE p.age > :age", PatientEntity.class);
        query.setParameter("age", age);
        return query.getResultList();
    }
}
