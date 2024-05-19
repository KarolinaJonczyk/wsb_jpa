//package com.capgemini.wsb.persistence.dao.impl;
//import com.capgemini.wsb.persistence.dao.PatientDAO;
//import com.capgemini.wsb.persistence.entity.PatientEntity;
//import org.springframework.stereotype.Repository;
//@Repository
//public abstract class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDAO
//{
//    @Override
//    public PatientEntity save(PatientEntity entity) {
//        return super.save(entity);
//    }
//
//}

package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDAO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDAO {



    @Override
    public PatientEntity findById(Long id) {
        return entityManager.find(PatientEntity.class, id);
    }

    @Override
    public PatientEntity findLastName(String lastName) {
        return null;
    }

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<PatientEntity> findByDateOfBirthAfter(LocalDate date) {
        return null;
    }

    @Override
    public List<VisitEntity> findAllVisitsByPatientId(Long patientId) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        PatientEntity patient = entityManager.find(PatientEntity.class, id);
        entityManager.remove(patient);
    }

    @Override
    public PatientEntity save(PatientEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public List<PatientEntity> moreThan2Visits(int visitCount) {
        return entityManager.createQuery(
                        "SELECT DISTINCT p FROM PatientEntity p " +
                                "JOIN p.visits v " +
                                "GROUP BY p " +
                                "HAVING COUNT(v) > :visitCount", PatientEntity.class)
                .setParameter("visitCount", visitCount)
                .getResultList();
    }
}
