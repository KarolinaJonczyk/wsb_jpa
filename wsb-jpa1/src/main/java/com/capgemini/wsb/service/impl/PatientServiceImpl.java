package com.capgemini.wsb.service.impl;
import com.capgemini.wsb.persistence.dao.PatientDAO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.dto.PatientTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PatientServiceImpl {
    private final PatientDAO patientDAO;
    @Autowired
    public PatientServiceImpl(PatientDAO pPatientDao) {
        this.patientDAO = pPatientDao;
    }
    public PatientTO findById(Long id) {
        final PatientEntity entity = patientDAO.findOne(id);
        return PatientMapper.mapToTO((PatientDAO) entity);
    }


    public void deletePatient(long id){
        patientDAO.delete(id);
    }

    public PatientTO saveOrUpdate(PatientTO patientTO) {
        PatientEntity entity = PatientMapper.mapToEntity(patientTO);

        PatientEntity savedEntity = patientDAO.save(entity);
        return PatientMapper.mapToTO((PatientDAO) savedEntity);
    }

    public List<PatientEntity> moreThan2Visits(int visitCount) {
        return patientDAO.moreThan2Visits(visitCount);
    }

}





