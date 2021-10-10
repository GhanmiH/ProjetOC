package com.api.SafetyNetAlerts.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.Data;


@Data
@Entity
@Table(name = "Medications")
public class Medications {

	@ManyToMany(cascade = {
		        CascadeType.PERSIST, 
		        CascadeType.MERGE
		    }
		)
	private static final Logger logger = LogManager.getLogger(Medications.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id_medication;

	@Column(name = "medication")
	private String medication;

	public Medications() {

	}  
	public Medications(int id_medication, String medication) {
		this.id_medication = id_medication;
		this.medication = medication;
	}

	public int getId_medication() {
		return id_medication;
	}

	public void setId_medication(int id_medication) {
		this.id_medication = id_medication;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	@Override
	public String toString() {
		return "Medications [id_medication=" + id_medication + ", medication=" + medication + "]";
	}

	
}
