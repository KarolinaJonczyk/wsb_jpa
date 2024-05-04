package com.capgemini.wsb.persistence.dao.impl;
import com.capgemini.wsb.persistence.dao.PatientDAO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;
@Repository
public abstract class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDAO
{
    @Override
    public PatientEntity save(PatientEntity entity) {
        return super.save(entity);
    }

}