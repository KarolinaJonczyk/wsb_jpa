package test.com.capgemini.wsb.service;

import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.DoctorMapper;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.AddressService;
import com.capgemini.wsb.service.DoctorService;
import com.capgemini.wsb.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.capgemini.wsb.service.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = WsbJpaApplication.class)
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientServiceImpl patientServiceImpl;
    @Autowired
    private PatientTO patientTO;


    @Transactional
    @DirtiesContext
    @Test
    public void testShouldRemovePatientVisits()
    {
        patientService.removePatientEntity(1L);
        PatientTO patientTO = patientService.findById(1L);
        PatientEntity patientEntity = PatientMapper.mapToEntity(patientTO);
        assertThat(patientEntity).isNull();
        DoctorTO doctorTO = doctorService.findById(1L);
        DoctorEntity doctorEntity = DoctorMapper.mapToEntity(doctorTO);
        assertThat(doctorEntity).isNotNull();
    }
}
