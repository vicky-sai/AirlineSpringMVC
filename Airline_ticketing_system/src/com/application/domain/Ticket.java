package com.application.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="ticket")
public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue
	@Column(name="ticket_id", unique = true, nullable = false)
	long ticket_id;
	
	@Column(name="count")
	private Integer count;
	
	@Column(name="total_amount")
	private Integer total_amount;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="passenger_id")
	@Autowired
	Passenger passenger;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="flight_id")
	@Autowired
	FlightDetails flightDetails;
	
	public Ticket() 
	{}

	public Ticket(long ticket_id, Integer count, Integer total_amount, Passenger passenger,FlightDetails flightDetails) {
		this.ticket_id = ticket_id;
		this.count = count;
		this.total_amount = total_amount;
		this.passenger = passenger;
		this.flightDetails = flightDetails;
	}
	
	public Ticket(Integer count, Integer total_amount, Passenger passenger, FlightDetails flightDetails) {
		this.count = count;
		this.total_amount = total_amount;
		this.passenger = passenger;
		this.flightDetails = flightDetails;
	}

	public long getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(long ticket_id) {
		this.ticket_id = ticket_id;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Integer total_amount) {
		this.total_amount = total_amount;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public FlightDetails getFlightDetails() {
		return flightDetails;
	}

	public void setFlightDetails(FlightDetails flightDetails) {
		this.flightDetails = flightDetails;
	}
	
	
}