package com.sprint2.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity       //One of the mandatory annotations. This annotation indicates that this class is a entity class
@Table(name="forest_admin17")    // @Table annotation is used to declare the table name 
public class Admin {
	@Id
	@GeneratedValue
	private Integer id;     // Id is automatically generated because of @Generatedvalue annotation
	private String adminName;
	private String adminPassword;
	
	public Admin() {   // zero-parametized constructor
		super();
	}

	public Admin(String adminName, String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	
	public Admin(Integer id, String adminName, String adminPassword) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}
	
}
