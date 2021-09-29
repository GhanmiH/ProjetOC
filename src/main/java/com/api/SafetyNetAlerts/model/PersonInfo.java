package com.api.SafetyNetAlerts.model;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersonInfo {
	
	private static final Logger logger = LogManager.getLogger(PersonInfo.class);
	
	String lastName;
    String address;
    int age;
    String email;
    List<Medications> medications;
    List<Allergies> allergies;
    
	public PersonInfo(String lastName, String address, int age, String email, List<Medications> medications,
			List<Allergies> allergies) {
		
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		this.email = email;
		this.medications = medications;
		this.allergies = allergies;
	}
	public PersonInfo() {
		
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Medications> getMedications() {
		return medications;
	}
	public void setMedications(List<Medications> medications) {
		this.medications = medications;
	}
	public List<Allergies> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<Allergies> allergies) {
		this.allergies = allergies;
	}
	@Override
	public String toString() {
		return "PersonInfo [lastName=" + lastName + ", address=" + address + ", age=" + age + ", email=" + email
				+ ", medications=" + medications + ", allergies=" + allergies + "]";
	}
	
    
}
