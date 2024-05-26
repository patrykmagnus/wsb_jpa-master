package com.capgemini.wsb.persistance.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private DoctorDao doctorDao;

    @Test
    public void testShouldFindPatientById() {
        //given
        long patientId = 2L; // Kendl Johnson

        // when
        PatientTO foundPatient = patientService.findById(patientId);

        //then
        assertThat(foundPatient).isNotNull();
        assertThat(foundPatient.getFirstName()).isEqualTo("Kendl");
        assertThat(foundPatient.getLastName()).isEqualTo("Johnson");
    }

    @Test
    @Transactional
    public void testShouldRemovePatientAndCascadeDeleteVisits() {
        // given
        long patientId = 2L; // Kendl Johnson
        long doctorCountBefore = doctorDao.count();
        List<VisitEntity> visitsBefore = visitDao.findByPatientId(patientId);

        // when
        patientService.delete(patientId);

        // then
        assertThat(patientDao.findById(patientId)).isNotPresent();
        for (VisitEntity visit : visitsBefore) {
            assertThat(visitDao.findById(visit.getId())).isNotPresent();
        }
        assertThat(doctorDao.count()).isEqualTo(doctorCountBefore);
    }

    @Test
    @Transactional
    public void testShouldFindPatientVisitAndDoctorByPatientId() {
        //given
        long patientId = 2L; // Kendl Johnson

        // when
        PatientTO foundPatient = patientService.findById(patientId);

        // then
        assertThat(foundPatient).isNotNull();
        assertThat(foundPatient.getId()).isEqualTo(patientId);
        assertThat(foundPatient.getFirstName()).isEqualTo("Kendl");
        assertThat(foundPatient.getLastName()).isEqualTo("Johnson");

        List<VisitEntity> visits = visitDao.findByPatientId(patientId);
        assertThat(visits).hasSize(2);
        assertThat(visits.get(0).getDescription()).isEqualTo("Regular check-up");
        assertThat(visits.get(1).getDescription()).isEqualTo("Follow-up visit");
        assertThat(visits.get(0).getDoctor().getFirstName()).isEqualTo("Carl");
        assertThat(visits.get(1).getDoctor().getFirstName()).isEqualTo("Lance");
    }

    @Test
    @Transactional
    public void testShouldFindAllVisitsByPatientId() {
        //given
        long patientId = 2L; // Kendl Johnson

        // when
        PatientTO foundPatient = patientService.findById(patientId);

        // then
        assertThat(foundPatient).isNotNull();
        List<VisitEntity> visits = visitDao.findByPatientId(patientId);
        assertThat(visits).isNotNull();
        assertThat(visits.get(0).getDescription()).isEqualTo("Regular check-up");
        assertThat(visits.get(1).getDescription()).isEqualTo("Follow-up visit");
    }
}
