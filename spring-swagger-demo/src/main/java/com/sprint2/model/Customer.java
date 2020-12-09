package com.sprint2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//mark class as an Entity
@Entity
//defining class name as Table name
@Table(name="Customer_details")
public class Customer {
	//Defining customerId as a primary key
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long customerId;
	
	private String customerName;
	private String customerEmail;
	private String customerPassword;
	private String customerAddress;
	private String customerTown;
	private String customerPostalcode;
	private String customerContact;
	public Customer()
	{
	
		super();
	}
	public Customer(Long customerId,String customerName,String customerEmail,String customerPassword,String customerAddress,String customerTown,String customerPostalcode,String customerContact)
	{
		super();
		this.customerId=customerId;
		this.customerName=customerName;
		this.customerEmail=customerEmail;
		this.customerPassword=customerPassword;
		this.customerAddress=customerAddress;
		this.customerTown=customerTown;
		this.customerPostalcode=customerPostalcode;
		this.customerContact=customerContact;
		
	}
	
	public Customer(String customerName,String customerEmail,String customerPassword,String customerAddress,String customerTown,String customerPostalcode,String customerContact)
	{
		
		super();
		this.customerName=customerName;
		this.customerEmail=customerEmail;
		this.customerPassword=customerPassword;
		this.customerAddress=customerAddress;
		this.customerTown=customerTown;
		this.customerPostalcode=customerPostalcode;
		this.customerContact=customerContact;
		
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public  String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerTown() {
		return customerTown;
	}
	public void setCustomerTown(String customerTown) {
		this.customerTown = customerTown;
	}
	public String getCustomerPostalcode() {
		return customerPostalcode;
	}
	public void setCustomerPostalcode(String customerPostalcode) {
		this.customerPostalcode = customerPostalcode;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerPassword=" + customerPassword + ", customerAddress=" + customerAddress
				+ ", customerTown=" + customerTown + ", customerPostalcode=" + customerPostalcode + ", customerContact="
				+ customerContact + "]";
	}
	
	
	

}