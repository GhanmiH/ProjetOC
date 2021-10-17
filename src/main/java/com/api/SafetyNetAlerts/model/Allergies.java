package com.api.SafetyNetAlerts.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Entity
@Table(name = "Allergies")
public class Allergies {
	
	
	private static final Logger logger = LogManager.getLogger(Allergies.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int allergie_id;
	
	@Column(name = "allergie")
	private String allergie;
	public Allergies() {
		
	}

	public Allergies(int allergie_id, String allergie) {
		
		this.allergie_id = allergie_id;
		this.allergie = allergie;
	}

	public int getAllergie_id() {
		return allergie_id;
	}

	public void setAllergie_id(int allergie_id) {
		this.allergie_id = allergie_id;
	}

	public String getAllergie() {
		return allergie;
	}

	public void setAllergie(String allergie) {
		this.allergie = allergie;
	}

	@Override
	public String toString() {
		return "Allergies [allergie_id=" + allergie_id + ", allergie=" + allergie + "]";
	}

}
