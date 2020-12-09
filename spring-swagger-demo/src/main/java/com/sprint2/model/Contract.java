package com.sprint2.model;

import java.util.List;
import javax.persistence.JoinColumn;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

//mark class as an Entity
@Entity

//defining class name as Table name
@Table(name="Contract_details")
public class Contract {
	
	// Defining product id as primary key
	@Id
	@GeneratedValue
	private Integer contractNumber;
	private String deliveryPlace;
	private String deliveryDate;
	private String quantity;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Product_info",joinColumns=@JoinColumn(name="productId"))
	private List<Product> product;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Customer_info",joinColumns=@JoinColumn(name="customerId"))
	private List<Customer> customer;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Scheduler",joinColumns=@JoinColumn(name="schedulerId"))
	private List<Scheduler> scheduler;
	
	
	public Contract() {
		
	}

	public Contract(Integer contractNumber, String deliveryPlace, String deliveryDate, String quantity) {
		super();
		this.contractNumber = contractNumber;
		this.deliveryPlace = deliveryPlace;
		this.deliveryDate = deliveryDate;
		this.quantity = quantity;
	}

	public Contract(String deliveryPlace, String deliveryDate, String quantity) {
		super();
		this.deliveryPlace = deliveryPlace;
		this.deliveryDate = deliveryDate;
		this.quantity = quantity;
	}

	
	

	public Integer getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(Integer contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getDeliveryPlace() {
		return deliveryPlace;
	}

	public void setDeliveryPlace(String deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Contract [contractNumber=" + contractNumber + ", deliveryPlace=" + deliveryPlace + ", deliveryDate="
				+ deliveryDate + ", quantity=" + quantity + "]";
	}
	
	
	
}