package test.com.capgemini.wsb.service;

import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.DoctorMapper;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.AddressService;
import com.capgemini.wsb.service.DoctorService;
import com.capgemini.wsb.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.capgemini.wsb.service.impl.PatientServiceImpl;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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



    public void setUp() {
        MockitoAnnotations.initMocks(this);
        patientTO = new PatientTO();
        patientTO.setId(1L);
        patientTO.setFirstName("John");
        patientTO.setLastName("Doe");
        patientTO.setTelephoneNumber("123456789");
        patientTO.setEmail("john.doe@example.com");
        patientTO.setPatientNumber("12345");
        patientTO.setDateOfBirth(LocalDate.of(1980, 1, 1));
        AddressEntity address = new AddressEntity();
        address.setAddressLine1("123 Street");
        address.setAddressLine2("Apt 1");
        address.setCity("City");
        address.setPostalCode("12345");
        patientTO.setAddress(address);
        Collection<VisitEntity> visits = new ArrayList<>();
        patientTO.setVisits(visits);
    }

    @Test
    public void testFindById() {
        when(patientService.findById(1L)).thenReturn(patientTO);

        PatientTO foundPatient = patientServiceImpl.findById(1L);

        assertThat(foundPatient).isNotNull();
        assertThat(foundPatient.getFirstName()).isEqualTo("Marcin");
        assertThat(foundPatient.getLastName()).isEqualTo("Maj");
    }

    @Test
    public void testSaveOrUpdate() {
        when(patientService.saveOrUpdate(any(PatientTO.class))).thenReturn(patientTO);

        PatientTO savedPatient = patientServiceImpl.saveOrUpdate(patientTO);

        assertThat(savedPatient).isNotNull();
        assertThat(savedPatient.getId()).isEqualTo(1L);
        verify(patientService, times(1)).saveOrUpdate(patientTO);
    }

    @Test
    public void testDelete() {
        doNothing().when(patientService).delete(1L);

        patientServiceImpl.deletePatient(1L);

        verify(patientService, times(1)).delete(1L);
    }
}
