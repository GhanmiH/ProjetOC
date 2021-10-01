package com.api.SafetyNetAlerts.model;

import java.util.List;

public class FloodPeople {

	 String lastName;
	    String firstName;
	    String phone;
	    int age;
	    List<String> medications;
	    List<String> allergies;
		public FloodPeople(String lastName, String firstName, String phone, int age, List<String> medications,
				List<String> allergies) {
			
			this.lastName = lastName;
			this.firstName = firstName;
			this.phone = phone;
			this.age = age;
			this.medications = medications;
			this.allergies = allergies;
		}
		public FloodPeople() {
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
			return "FloodPeople [lastName=" + lastName + ", firstName=" + firstName + ", phone=" + phone + ", age="
					+ age + ", medications=" + medications + ", allergies=" + allergies + "]";
		}
	    
}
