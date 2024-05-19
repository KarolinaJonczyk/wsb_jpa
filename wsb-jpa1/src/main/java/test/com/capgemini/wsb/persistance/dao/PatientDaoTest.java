package test.com.capgemini.wsb.persistance.dao;
import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.dao.PatientDAO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WsbJpaApplication.class)
public class PatientDaoTest {
    @Autowired
    private PatientDAO patientDao;

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        Long patientId = 1L;
        PatientEntity retrievedPatient = patientDao.findById(patientId);
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

        final PatientEntity newSaved = patientDao.findById(saved.getId());
        assertThat(newSaved).isNotNull();
        patientDao.delete(saved.getId());


        final PatientEntity removed = patientDao.findById(saved.getId());
        assertThat(removed).isNull();
    }
    @Transactional
    @Test
    public void testShouldFindPatientsByLastName() {
        List<PatientEntity> patients = Collections.singletonList(patientDao.findLastName("Kot"));
        assertThat(patients).isNotEmpty();
        assertThat(patients).allMatch(patient -> "Kot".equals(patient.getLastName()));
    }
    @Transactional
    @Test
    public void testShouldFindPatientsByDateOfBirthAfter() {
        LocalDate date = LocalDate.of(2000, 1, 1);
        List<PatientEntity> patients = patientDao.findByDateOfBirthAfter(date);
        assertThat(patients).isNotEmpty();
        assertThat(patients).allMatch(patient -> patient.getDateOfBirth().isAfter(date));
    }
    @Transactional
    @Test
    public void testShouldFindPatientsWithMoreThanOneVisits() {
        int visitCount = 2;
        List<PatientEntity> patients = patientDao.moreThan2Visits(visitCount);

        // Assercje dotyczące wyników
        assertThat(patients).isNotEmpty();
        assertThat(patients).allMatch(patient -> patient.getVisits().size() > visitCount);
    }

    @Transactional
    @Test
    public void testShouldFindAllVisitsByPatientId() {
        Long patientId = 1L;
        List<VisitEntity> visits = patientDao.findAllVisitsByPatientId(patientId);
        assertThat(visits).isNotEmpty();
        assertThat(visits).allMatch(visit -> visit.getId().equals(patientId));
    }

}
