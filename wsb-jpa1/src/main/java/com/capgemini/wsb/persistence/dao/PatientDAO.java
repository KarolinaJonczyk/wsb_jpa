package com.capgemini.wsb.persistence.dao;
import com.capgemini.wsb.persistence.entity.PatientEntity;

public interface PatientDAO extends Dao<PatientEntity, Long>
{
    PatientEntity findId(Long id);
    PatientEntity findLastName(String lastName);
    PatientEntity save(PatientEntity entity);

}