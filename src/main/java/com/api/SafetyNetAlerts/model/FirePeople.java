package com.api.SafetyNetAlerts.model;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FirePeople {

	private static final Logger logger = LogManager.getLogger(FirePeople.class);

	String lastName;
	String firstName;
	String phone;
	int age;
	List<Medications> medications;
	List<Allergies> allergies;

	public FirePeople(String lastName, String firstName, String phone, int age, List<Medications> medications,
			List<Allergies> allergies) {

		this.lastName = lastName;
		this.firstName = firstName;
		this.phone = phone;
		this.age = age;
		this.medications = medications;
		this.allergies = allergies;
	}

	public FirePeople() {
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Medications> getMedications() {
		return medications;
	}

	public void setMedications(List<Medications> list) {
		this.medications = list;
	}

	public List<Allergies> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<Allergies> list) {
		this.allergies = list;
	}

	@Override
	public String toString() {
		return "FirePeople [lastName=" + lastName + ", firstName=" + firstName + ", phone=" + phone + ", age=" + age
				+ ", medications=" + medications + ", allergies=" + allergies + "]";
	}

}