package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDAO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.dto.PatientTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {
    @Autowired
    private PatientDAO patientDao;

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        Long patientId = 1L;
        PatientEntity retrievedPatient = patientDao.findId(patientId);
        assertThat(retrievedPatient).isNotNull();
        assertThat(retrievedPatient.getLastName()).isEqualTo("Maj");
    }

    @Transactional
    @Test
    public void testShouldFindPatientByLastName() {

        PatientEntity retrievedPatient = patientDao.findLastName("Kot");
        assertThat(retrievedPatient).isNotNull();
        assertThat(retrievedPatient.getFirstName()).isEqualTo("Klementyna");
    }

    @Transactional
    @Test
    public void testShouldSaveAndRemovePatient() {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("Daniel");
        patientEntity.setLastName("Dynia");
        patientEntity.setTelephoneNumber("918273465");
        patientEntity.setEmail("dynia.d@mail.com");
        patientEntity.setPatientNumber("0012221");

        final PatientEntity saved = patientDao.save(patientEntity);
        assertThat(saved.getId()).isNotNull();

        final PatientEntity newSaved = patientDao.findId(saved.getId());
        assertThat(newSaved).isNotNull();
        patientDao.delete(saved.getId());


        final PatientEntity removed = patientDao.findId(saved.getId());
        assertThat(removed).isNull();
    }
}
