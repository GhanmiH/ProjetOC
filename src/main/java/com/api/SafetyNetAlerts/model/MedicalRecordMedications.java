package com.api.SafetyNetAlerts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.Data;

@Data
@Entity
@Table(name = "Medical_Record_Medications")
public class MedicalRecordMedications {

	public MedicalRecordMedications() {
		
	}
	
	private static final Logger logger = LogManager.getLogger(MedicalRecordMedications.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int  medical_record_medications_id;

	@Column(name = "personId")
	private int personId;
	
	@Column(name = "id_medication")
	private int  medicationId;

	public MedicalRecordMedications(int medical_record_medications_id, int medicalRecordId, int medicationId) {
		
		this.medical_record_medications_id = medical_record_medications_id;
		this.personId = medicalRecordId;
		this.medicationId = medicationId;
	}

	public int getMedical_record_medications_id() {
		return medical_record_medications_id;
	}

	public void setMedical_record_medications_id(int medical_record_medications_id) {
		this.medical_record_medications_id = medical_record_medications_id;
	}

	public int getMedicalRecordId() {
		return personId;
	}

	public void setMedicalRecordId(int medicalRecordId) {
		this.personId = medicalRecordId;
	}

	public int getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(int medicationId) {
		this.medicationId = medicationId;
	}

	@Override
	public String toString() {
		return "MedicalRecordMedications [medical_record_medications_id=" + medical_record_medications_id
				+ ", medicalRecordId=" + personId + ", medicationId=" + medicationId + "]";
	}

	
	
}
