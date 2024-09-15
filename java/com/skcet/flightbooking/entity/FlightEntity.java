package com.skcet.flightbooking.entity;


import java.sql.Date;
import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


@Entity
public class FlightEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 
	private long flightId;
	private String flightName;
	private int seats;
	private String classType;
	private String destination;
	private String boarding;
	private Date date;

	
	
		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="fk_id")
		@Fetch(FetchMode.JOIN)
		private Set<PassengerEntity> passengerEntity;
		
			
	public long getFlightId() {
			return flightId;
		}
		public void setFlightId(long flightId) {
			this.flightId = flightId;
		}
		public String getFlightName() {
			return flightName;
		}
		public void setFlightName(String flightName) {
			this.flightName = flightName;
		}
		public int getSeats() {
			return seats;
		}
		public void setSeats(int seats) {
			this.seats = seats;
		}
		public String getClassType() {
			return classType;
		}
		public void setClassType(String classType) {
			this.classType = classType;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getBoarding() {
			return boarding;
		}
		public void setBoarding(String boarding) {
			this.boarding = boarding;
		}
		
		
		
	public FlightEntity(long flightId, String flightName, int seats, String classType, String destination,
				String boarding,Date date) {
			super();
			this.flightId = flightId;
			this.flightName = flightName;
			this.seats = seats;
			this.classType = classType;
			this.destination = destination;
			this.boarding = boarding;
			this.date = date;
		}
	
	
	
	
	public FlightEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Set<PassengerEntity> getPassengerEntity() {
		return passengerEntity;
	}
	public void setPassengerEntity(Set<PassengerEntity> passengerEntity) {
		this.passengerEntity = passengerEntity;
	}
	
	

   	
	
}