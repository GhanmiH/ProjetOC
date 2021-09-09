package com.api.SafetyNetAlerts.model;

import java.util.List;

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
//@Entity
//@Table(name = "Medical_Record")
public class MedicalRecord {

	private static final Logger logger = LogManager.getLogger(MedicalRecord.class);

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column
	private int id;

	//@Column(name = "Personid")
	private int personId;

	//@Column(name = "Allergies")
	private List<String> medications;

	//@Column(name = "Medications")
	private List<String> allergies;

	public MedicalRecord(int id, int personId, List<String> medications, List<String> allergies) {
	
		this.id = id;
		this.personId = personId;
		this.medications = medications;
		this.allergies = allergies;
	}

	public MedicalRecord() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public List<String> getMedications() {
		return medications;
	}

	public void setMedications(List<String> medications) {
		this.medications = medications;
	}

	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

	@Override
	public String toString() {
		return "MedicalRecord [id=" + id + ", personId=" + personId + ", medications=" + medications + ", allergies="
				+ allergies + "]";
	}	
}