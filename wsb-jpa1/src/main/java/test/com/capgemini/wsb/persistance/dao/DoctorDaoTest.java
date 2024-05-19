package test.com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.enums.Specialization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorDaoTest {
    @Autowired
    private DoctorDao doctorDao;

    @Transactional
    @Test
    public void testShouldFindDoctorById() {
        Long doctorId = 1L;
        DoctorEntity retrievedDoctor = doctorDao.findOne(doctorId);

        assertThat(retrievedDoctor).isNotNull();
        assertThat(retrievedDoctor.getLastName()).isEqualTo("Zdrowy");
    }

    @Transactional
    @Test
    public void testShouldSaveAndRemoveDoctor() {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setFirstName("Natalia");
        doctorEntity.setLastName("Niesmaczna");
        doctorEntity.setTelephoneNumber("8921674356");
        doctorEntity.setEmail("dr-gp2@mail.com");
        doctorEntity.setDoctorNumber("5");
        doctorEntity.setSpecialization(Specialization.GP);

        final DoctorEntity saved = doctorDao.save(doctorEntity);
        assertThat(saved.getId()).isNotNull();

        final DoctorEntity newSaved = doctorDao.findOne(saved.getId());
        assertThat(newSaved).isNotNull();
        doctorDao.delete(saved.getId());
        final DoctorEntity removed = doctorDao.findOne(saved.getId());
        assertThat(removed).isNull();
    }

   }
