package com.api.SafetyNetAlerts.model;



import java.util.List;


public class FireList {
	 String address;
	 String station;
	    List<String> firestation;
	    List<FirePeople> firePeopleList;
		
	    public FireList(String address, List<String> firestation, List<FirePeople> firePeopleList  ) {
			this.address = address;
			this.firestation = firestation;
			this.firePeopleList = firePeopleList;
		}

		public FireList() {
			
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public List<String> getFirestation() {
			return firestation;
		}

		public void setFirestation(List<String> stationList) {
			this.firestation = stationList;
		}

		public List<FirePeople> getFirePeopleList() {
			return firePeopleList;
		}

		public void setFirePeopleList(List<FirePeople> firePeopleList) {
			this.firePeopleList = firePeopleList;
		}

		@Override
		public String toString() {
			return "FireList [address=" + address + ", firestation=" + firestation + ", firePeopleList="
					+ firePeopleList + "]";
		}
	    

	}