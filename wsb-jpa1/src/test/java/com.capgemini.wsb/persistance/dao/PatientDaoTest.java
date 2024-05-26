package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Test
    @Transactional
    public void testFindByLastName() {
        List<PatientEntity> patients = patientDao.findByLastName("Johnson");
        assertThat(patients).isNotEmpty();
    }

    @Test
    @Transactional
    public void testFindByVisitCountGreaterThan() {
        List<PatientEntity> patients = patientDao.findByVisitCountGreaterThan(1);
        assertThat(patients).isNotEmpty();
    }

    @Test
    @Transactional
    public void testFindByAgeGreaterThan() {
        List<PatientEntity> patients = patientDao.findByAgeGreaterThan(30);
        assertThat(patients).isNotEmpty();
    }
}
