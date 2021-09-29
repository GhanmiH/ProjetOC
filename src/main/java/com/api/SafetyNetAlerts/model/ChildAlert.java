package com.api.SafetyNetAlerts.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChildAlert {
	
	private static final Logger logger = LogManager.getLogger(ChildAlert.class);
	
	String firstName;
    String lastName;
    int age;
	public ChildAlert(String firstName, String lastName, int age) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	public ChildAlert() {
		
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "ChildAlert [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
    
    
}
