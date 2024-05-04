package com.capgemini.wsb.service.impl;
import com.capgemini.wsb.persistence.dao.PatientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientServiceImpl {
    private final PatientDAO patientDAO;

    @Autowired
    public PatientServiceImpl(PatientDAO pPatientDao, PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
        pPatientDao = pPatientDao;
    }

}


