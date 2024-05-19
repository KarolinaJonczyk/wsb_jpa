package com.capgemini.wsb.dto;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;

import java.time.LocalDateTime;
import java.util.List;
public class VisitTO {
    private Long id;
    private String description;
    private PatientTO patient;
    private DoctorTO doctor;
    private LocalDateTime time_visit;
    private List<MedicalTreatmentEntity> medicalTreatments;

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PatientTO getPatient() {
        return patient;
    }

    public void setPatient(PatientTO patient) {
        this.patient = patient;
    }

    public DoctorTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }
    public LocalDateTime getTime() {
        return time_visit;
    }

    public void setTime(LocalDateTime time_visit) {
        this.time_visit = time_visit;
    }

    public List<MedicalTreatmentEntity> getMedicalTreatments() {
        return medicalTreatments;
    }

    public void setMedicalTreatments(List<MedicalTreatmentEntity> medicalTreatments) {
        this.medicalTreatments = medicalTreatments;
    }
}
