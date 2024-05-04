package com.capgemini.wsb.mapper;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
public class PatientMapper {
    public static PatientTO maptToTO(final PatientEntity patientEntity)
    {
        if ( patientEntity== null)
        {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setVisits(patientEntity.getVisits());
        patientTO.setId(patientEntity.getId());

        patientTO.setVisits(patientEntity.getVisits());
        return patientTO;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO)
    {
        if (patientTO == null)
        {
            return null;
        }
        final PatientEntity patientEntity = new PatientEntity();
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getAddress());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setId(patientTO.getId());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setVisits(patientTO.getVisits());
        patientEntity.setLastName(patientTO.getLastName());
        return patientEntity;
    }
}
