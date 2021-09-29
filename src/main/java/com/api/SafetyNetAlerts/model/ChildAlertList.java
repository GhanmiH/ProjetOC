package com.api.SafetyNetAlerts.model;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChildAlertList {

	private static final Logger logger = LogManager.getLogger(ChildAlertList.class);
	
    List<ChildAlert> child;
    List<Person> otherFamilyMembers;
    
	public ChildAlertList(List<ChildAlert> child, List<Person> otherFamilyMembers) {
		super();
		this.child = child;
		this.otherFamilyMembers = otherFamilyMembers;
	}

	public ChildAlertList() {
		
	}

	public List<ChildAlert> getChild() {
		return child;
	}

	public void setChild(List<ChildAlert> child) {
		this.child = child;
	}

	public List<Person> getOtherFamilyMembers() {
		return otherFamilyMembers;
	}

	public void setOtherFamilyMembers(List<Person> otherFamilyMembers) {
		this.otherFamilyMembers = otherFamilyMembers;
	}

	@Override
	public String toString() {
		return "ChildAlertList [child=" + child + ", otherFamilyMembers=" + otherFamilyMembers + "]";
	}


}