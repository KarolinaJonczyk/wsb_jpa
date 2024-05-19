package com.capgemini.wsb.persistence.dao.impl;
import com.capgemini.wsb.persistence.dao.PatientDAO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public class PatientDaoImpl extends  AbstractDao<PatientEntity, Long> implements PatientDAO {
    @Override
    public PatientEntity findById(Long id) {
        return entityManager.find(PatientEntity.class, id);
    }

    @Override
    public PatientEntity findLastName(String lastName) {
         return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class)
                     .setParameter("lastName", lastName)
                     .getSingleResult();
    }

    @Override
    public PatientEntity save(PatientEntity entity) {
        return super.save(entity);
    }

    @Override
    public List<PatientEntity> moreThan2Visits(int visitCount) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE size(p.visits) > :visitCount", PatientEntity.class)
                .setParameter("visitCount", visitCount)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findByLastName(String lastName)
    {
        List<PatientEntity> patients;
        patients = entityManager.createQuery("SELECT p FROM PatientEntity p " +
                                "WHERE p.lastName LIKE :lastName"
                        , PatientEntity.class)
                .setParameter("lastName", "%" + lastName + "%")
                .getResultList();
        return patients;
    }

    @Override
    public List<PatientEntity> findByDateOfBirthAfter(LocalDate date) {
         return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.dateOfBirth > :date", PatientEntity.class)
                     .setParameter("date", date)
                     .getResultList();
    }

    @Override
    public List<VisitEntity> findAllVisitsByPatientId(Long patientId) {
        return entityManager.createQuery("SELECT v FROM VisitEntity v WHERE v.patient.id = :patientId", VisitEntity.class)
                     .setParameter("patientId", patientId)
                     .getResultList();
    }

    @Override
    public void deleteById(Long id) {
        PatientEntity patient = findById(id);
        if (patient != null) {
            entityManager.remove(patient);
        }
    }
}

