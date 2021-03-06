package com.api.SafetyNetAlerts.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FireStationPeople {
	
	private static final Logger logger = LogManager.getLogger(FireStationPeople.class);

	String firstName;
    String lastName;
    String address;
    String phone;
	public FireStationPeople(String firstName, String lastName, String address, String phone) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
	}
	public FireStationPeople() {
		
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "FireStationPeople [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", phone=" + phone + "]";
	}
    
}
