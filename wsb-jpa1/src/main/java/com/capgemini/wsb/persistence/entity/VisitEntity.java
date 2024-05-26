package com.capgemini.wsb.persistence.entity;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.capgemini.wsb.persistence.enums.TreatmentType;

import java.time.LocalDateTime;


@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	private TreatmentType type;

	@Column(name = "time_visit")
	private LocalDateTime timeVisit;


	@ManyToOne
	@JoinColumn(name="VISIT_ID")
	private VisitEntity visit;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private DoctorEntity doctor;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TreatmentType getType() {
		return type;
	}

	public void setType(TreatmentType type) {
		this.type = type;
	}

	@JsonIgnore
	public VisitEntity getVisit() {
		return visit;
	}

	public void setVisit(VisitEntity visit) {
		this.visit = visit;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}
}
