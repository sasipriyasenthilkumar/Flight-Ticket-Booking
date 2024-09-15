package com.skcet.flightbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PassengerEntity {
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
  private int passengerId;
  private String passengerName;
	private String passengerContact;
	private String passengerAddress;
	private String passengerMail;
	private  int passengerAge;
	private String passengerGender;
	public PassengerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PassengerEntity(int passengerId, String passengerName, String passengerContact, String passengerAddress,
			String passenegrMail, int passengerAge, String passengerGender) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerContact = passengerContact;
		this.passengerAddress = passengerAddress;
		this.passengerMail = passenegrMail;
		this.passengerAge = passengerAge;
		this.passengerGender = passengerGender;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerContact() {
		return passengerContact;
	}
	public void setPassengerContact(String passengerContact) {
		this.passengerContact = passengerContact;
	}
	public String getPassengerAddress() {
		return passengerAddress;
	}
	public void setPassengerAddress(String passengerAddress) {
		this.passengerAddress = passengerAddress;
	}
	public String getPassenegrMail() {
		return passengerMail;
	}
	public void setPassenegrMail(String passenegrMail) {
		this.passengerMail = passenegrMail;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public String getPassengerGender() {
		return passengerGender;
	}
	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}
	
	
	
	
 
}