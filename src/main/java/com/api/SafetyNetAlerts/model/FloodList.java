package com.api.SafetyNetAlerts.model;

import java.util.List;

public class FloodList {

	 String station;
	    String address;
	    List<FloodPeople> floodPeopleList;
		public FloodList(String station, String address, List<FloodPeople> floodPeopleList) {
			
			this.station = station;
			this.address = address;
			this.floodPeopleList = floodPeopleList;
		}
		public FloodList() {
			
		}
		public String getStation() {
			return station;
		}
		public void setStation(String station) {
			this.station = station;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public List<FloodPeople> getFloodPeopleList() {
			return floodPeopleList;
		}
		public void setFloodPeopleList(List<FloodPeople> floodPeopleList) {
			this.floodPeopleList = floodPeopleList;
		}
		@Override
		public String toString() {
			return "FloodList [station=" + station + ", address=" + address + ", floodPeopleList=" + floodPeopleList
					+ "]";
		}
	    
	    
}
