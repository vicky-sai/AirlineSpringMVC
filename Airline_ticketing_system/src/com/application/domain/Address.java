package com.application.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
    private Integer address_id;
	
	@Column(name = "doorNo")
    private  Integer doorNo;
	
	@Column(name = "street")
    private String street;
	
	@Column(name = "city")
    private String city;
	 
	@Column(name = "country")
    private String country; 
	
	@Column(name = "pincode")
    private Integer pincode;

	public Address()
	{}
	public Address(Integer address_id, Integer doorNo, String street, String city, String country, Integer pincode) {
		this.address_id = address_id;
		this.doorNo = doorNo;
		this.street = street;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
	}
	public Address(Integer doorNo, String street, String city, String country, Integer pincode) {
		this.doorNo = doorNo;
		this.street = street;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
	}

	public Integer getId() {
		return address_id;
	}

	public void setId(Integer address_id) {
		this.address_id = address_id;
	}

	public Integer getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(Integer doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}


}
