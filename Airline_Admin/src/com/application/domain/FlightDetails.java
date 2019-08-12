package com.application.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="flightDetails")
public class FlightDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="flight_id")
	private long flight_id;
	
	@Column(name="airplane_id")
	long airplane_id;
	
	@Column(name="source")
	private String source;
	
	@Column(name="dest")
	private String dest;
	
	@Column(name="deptTime")
	private String deptTime;
	
	@Column(name="arrivalTime")
	private String arrivalTime;
	
	@Column(name="travelClass")
	private String travelClass;
	
	@Column(name="totalSeats")
	private int totalSeats;
	
	@Column(name="availableSeats")
	private int availableSeats;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="deptDate")
	private Date deptDate;

	public FlightDetails()
	{}

	public FlightDetails(long airplane_id, String source, String dest, String deptTime, String arrivalTime,
			String travelClass, int totalSeats, int availableSeats, int amount, Date deptDate) {
		this.airplane_id = airplane_id;
		this.source = source;
		this.dest = dest;
		this.deptTime = deptTime;
		this.arrivalTime = arrivalTime;
		this.travelClass = travelClass;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.amount = amount;
		this.deptDate = deptDate;
	}

	public FlightDetails(long flight_id, long airplane_id, String source, String dest, String deptTime,
			String arrivalTime, String travelClass, int totalSeats, int availableSeats, int amount, Date deptDate) {
		this.flight_id = flight_id;
		this.airplane_id = airplane_id;
		this.source = source;
		this.dest = dest;
		this.deptTime = deptTime;
		this.arrivalTime = arrivalTime;
		this.travelClass = travelClass;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.amount = amount;
		this.deptDate = deptDate;
	}

	public long getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(long flight_id) {
		this.flight_id = flight_id;
	}

	public long getAirplane_id() {
		return airplane_id;
	}

	public void setAirplane_id(long airplane_id) {
		this.airplane_id = airplane_id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getDeptTime() {
		return deptTime;
	}

	public void setDeptTime(String deptTime) {
		this.deptTime = deptTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDeptDate() {
		return deptDate;
	}

	public void setDeptDate(Date deptDate) {
		this.deptDate = deptDate;
	}
	
}