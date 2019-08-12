package com.application.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	  private Integer admin_id; 
	
	@Column(name = "adminName", nullable=false)
	  private String adminName;
	
	@Column(name = "userName", nullable=false, unique=true)
	  private String userName;
	
	@Column(name = "password", nullable=false)
	  private String password;

	public Admin()
	{}
	public Admin(Integer admin_id, String adminName, String userName, String password) {
		this.admin_id = admin_id;
		this.adminName = adminName;
		this.userName = userName;
		this.password = password;
	}
	public Admin(String adminName, String userName, String password) {
		this.adminName = adminName;
		this.userName = userName;
		this.password = password;
	}
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
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

}
