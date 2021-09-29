package com.api.SafetyNetAlerts.model;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FireStationPeopleList {

	private static final Logger logger = LogManager.getLogger(FireStationPeopleList.class);

	int child;
    int adult;
    List<FireStationPeople> fireStationPeople;
    
	public FireStationPeopleList(int child, int adult, List<FireStationPeople> fireStationPeople) {
		super();
		this.child = child;
		this.adult = adult;
		this.fireStationPeople = fireStationPeople;
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

	public List<FireStationPeople> getFirestationPeople() {
		return fireStationPeople;
	}

	public void setFirestationPeople(List<FireStationPeople> firestationPeople) {
		this.fireStationPeople = firestationPeople;
	}

	@Override
	public String toString() {
		return "FireStationPeopleList [child=" + child + ", adult=" + adult + ", fireStationPeople=" + fireStationPeople
				+ "]";
	}
    
    
}
