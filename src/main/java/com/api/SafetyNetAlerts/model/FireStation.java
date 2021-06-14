package com.api.SafetyNetAlerts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.api.SafetyNetAlerts.SafetyNetAlertsApplication;

@Entity
public class FireStation {
	
	private static final Logger logger = LogManager.getLogger(FireStation.class);

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String address;
    private int station;
    
    
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

      public int getstation() {
        return station;
      }

      public void set(int station) {
        this.station = station;
      }
}
