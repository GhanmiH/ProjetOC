package com.api.SafetyNetAlerts.model;

import java.util.List;

public class FireStationPeopleList {
    int child;
    int adult;
    List<FirestationPeople> firestationPeople;
	public FireStationPeopleList(int child, int adult, List<FirestationPeople> firestationPeople) {
		
		this.child = child;
		this.adult = adult;
		this.firestationPeople = firestationPeople;
	}
	public FireStationPeopleList() {
		
	}
	public int getChild() {
		return child;
	}
	public void setChild(int child) {
		this.child = child;
	}
	public int getAdult() {
		return adult;
	}
	public void setAdult(int adult) {
		this.adult = adult;
	}
	public List<FirestationPeople> getFirestationPeople() {
		return firestationPeople;
	}
	public void setFirestationPeople(List<FirestationPeople> firestationPeople) {
		this.firestationPeople = firestationPeople;
	}
	@Override
	public String toString() {
		return "FireStationPeopleList [child=" + child + ", adult=" + adult + ", firestationPeople=" + firestationPeople
				+ "]";
	}
	


}