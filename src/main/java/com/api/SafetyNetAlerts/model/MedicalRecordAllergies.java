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
@Table(name = " medical_record_allergies")
public class MedicalRecordAllergies {

	private static final Logger logger = LogManager.getLogger(MedicalRecordAllergies.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column(name = "Id_medical_record")
	private int id_medical_record;

	@Column(name = "Id_allergie")
	private int id_allergie;

	public MedicalRecordAllergies(Integer medical_record_allergies_id, int id_medical_record, int id_allergie) {
		
		this.id = medical_record_allergies_id;
		this.id_medical_record = id_medical_record;
		this.id_allergie = id_allergie;
	}

	public MedicalRecordAllergies() {
		
	}

	public Integer getMedical_record_allergies_id() {
		return id;
	}

	public void setMedical_record_allergies_id(Integer medical_record_allergies_id) {
		this.id = medical_record_allergies_id;
	}

	public int getId_medical_record() {
		return id_medical_record;
	}

	public void setId_medical_record(int id_medical_record) {
		this.id_medical_record = id_medical_record;
	}

	public int getId_allergie() {
		return id_allergie;
	}

	public void setId_allergie(int id_allergie) {
		this.id_allergie = id_allergie;
	}

	@Override
	public String toString() {
		return "MedicalRecordAllergies [id=" + id
				+ ", id_medical_record=" + id_medical_record + ", id_allergie=" + id_allergie + "]";
	}

	
}
