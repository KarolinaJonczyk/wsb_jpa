package com.capgemini.wsb.persistence.dao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import java.util.List;
import java.time.LocalDate;
import com.capgemini.wsb.persistence.entity.VisitEntity;


public interface PatientDAO extends Dao<PatientEntity, Long>
{
    PatientEntity findId(Long id);
    PatientEntity findLastName(String lastName);
    PatientEntity save(PatientEntity entity);
    List<PatientEntity> moreThan2Visits(int visitCount);
    List<PatientEntity> findByLastName(String lastName);
    List<PatientEntity> findByDateOfBirthAfter(LocalDate date);
    List<VisitEntity> findAllVisitsByPatientId(Long patientId);

}