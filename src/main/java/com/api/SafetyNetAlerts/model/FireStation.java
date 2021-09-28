package com.api.SafetyNetAlerts.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.Data;


@Data
@Entity
@Table(name = "FireStation")

public class FireStation {

	private static final Logger logger = LogManager.getLogger(FireStation.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column(name = "Address")
	private String address;

	@Column(name = "Station")
	private String station;

	public FireStation(String address, String station) {
		this.address = address;
		this.station = station;
	
	}
	
	 public FireStation() {
	    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStation() {
		return station;
	}

	public void setstation(String station) {
		this.station = station;
	}

	@Override
	public String toString() {
		return "FireStation [id=" + id + ", address=" + address + ", station=" + station + "]";
	}
}
