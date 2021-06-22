package com.api.SafetyNetAlerts.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Data
@Entity
@Table(name = "Medical_Record")
public class MedicalRecord {

	private static final Logger logger = LogManager.getLogger(MedicalRecord.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(name = "First_name")
	private String firstName;
	
	@Column(name = "Last_name")
	private String lastName;
	
	@Column(name = "Birthdate")
	private Date birthdate;
	
	@ElementCollection
	@Column(name = "Allergies")
	private List <String> allergies;
	
	@ElementCollection
	@Column(name = "Medications")
	private List<String> medications;
	
	
	
	public MedicalRecord(String firstName, String lastName, Date birthdate,List<String> allergies, List<String> medications, int age) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.birthdate=birthdate;
		this.allergies=allergies;
		this.medications=medications;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

	public List<String> getMedications() {
		return medications;
	}

	public void setMedications(List<String> medications) {
		this.medications = medications;
	}

	@Override
	public String toString() {
		return "MedicalRecord [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthdate="
				+ birthdate + ", allergies=" + allergies + ", medications=" + medications + "]";
	}


	
	

}
