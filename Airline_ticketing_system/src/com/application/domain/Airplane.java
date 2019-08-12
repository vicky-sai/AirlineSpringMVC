package com.application.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="airplane")
public class Airplane implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue
	@Column(name="airplane_id", unique = true, nullable = false)
	private long airplane_id;
	
	@Column(name="airlineName")
	private String airlineName;

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="airplane_id") 
	private Set<FlightDetails> flightDetails;
	
	public Airplane()
	{}

	public Airplane(String airlineName, Set<FlightDetails> flightDetails) {
		this.airlineName = airlineName;
		this.flightDetails = flightDetails;
	}

	public Airplane(long airplane_id, String airlineName, Set<FlightDetails> flightDetails) {
		this.airplane_id = airplane_id;
		this.airlineName = airlineName;
		this.flightDetails = flightDetails;
	}

	public long getAirplane_id() {
		return airplane_id;
	}

	public void setAirplane_id(long airplane_id) {
		this.airplane_id = airplane_id;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public Set<FlightDetails> getFlights() {
		return flightDetails;
	}

	public void setFlights(Set<FlightDetails> flightDetails) {
		this.flightDetails = flightDetails;
	}
	

}