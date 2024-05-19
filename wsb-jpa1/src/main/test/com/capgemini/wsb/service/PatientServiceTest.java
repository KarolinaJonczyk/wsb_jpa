package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class PatientServiceTest {

    @Mock
    private PatientService patientService;

    @InjectMocks
    private PatientServiceImpl patientServiceImpl;

    private PatientTO patientTO;

    @Before
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
        assertThat(foundPatient.getFirstName()).isEqualTo("John");
        assertThat(foundPatient.getLastName()).isEqualTo("Doe");
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

        patientServiceImpl.delete(1L);

        verify(patientService, times(1)).delete(1L);
    }
}
