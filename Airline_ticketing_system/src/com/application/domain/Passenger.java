 package com.application.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "Passenger")
public class Passenger implements Serializable
{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "passenger_id")
	private Integer passenger_id; 
	@Column(name = "passengerName", nullable=false)
	  private String passengerName;
	@Column(name = "email")
	  private String email;
	@Column(name = "mobileNumber", nullable=false)
	  private Long mobileNumber;
	@Column(name = "dateOfBirth")
	private Date dateOfBirth;
	
	@Column(name = "userName", nullable=false, unique=true)
	  private String userName;
	
	@Column(name = "password", nullable=false)
	  private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@ForeignKey(name="address")
	  private Address address;

	public Passenger(String passengerName, String email, Long mobileNumber, Date dateOfBirth, String userName,
			String password, Address address) {
		this.passengerName = passengerName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.userName = userName;
		this.password = password;
		this.address = address;
	}

	public Passenger()
	{}
	public Passenger(Integer passenger_id, String passengerName, String email, Long mobileNumber, Date dateOfBirth,
			String userName, String password, Address address) {
		this.passenger_id = passenger_id;
		this.passengerName = passengerName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.userName = userName;
		this.password = password;
		this.address = address;
	}

	public Integer getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(Integer passenger_id) {
		this.passenger_id = passenger_id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
