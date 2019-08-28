package com.joeknowles.Relationships.models;

import java.util.Date;

public class FormLicense {

	private int personId;
	private String state;
	private Date expirationDate;
	
	public int getPersonId() { return personId; }
	public void setPersonId(int personId) { this.personId = personId; }
	public String getState() { return state; }
	public void setState(String state) { this.state = state; }
	public Date getExpirationDate() { return expirationDate; }
	public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }
}
