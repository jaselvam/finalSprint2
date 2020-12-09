package com.sprint2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

//mark class as an Entity
@Entity
//defining class name as Table name
@Table(name="Order2")
public class Order {
	
	// Defining orderNumber as primary key
	@Id
	@GeneratedValue
	private Integer id;
	private String deliveryDate;
	private String deliveryPlace;
	private String quantity;
	
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Customer_info",joinColumns=@JoinColumn(name="customerId"))
	private List<Customer> customer;
	
	
	public Order() {
		super();
	}
	


	public Order(Integer id, String deliveryPlace, String deliveryDate, String quantity) {
		super();
		this.id = id;
		this.deliveryPlace = deliveryPlace;
		this.deliveryDate = deliveryDate;
		this.quantity = quantity;
	}




	
	public Order(String deliveryPlace, String deliveryDate, String quantity) {
		super();
		this.deliveryPlace = deliveryPlace;
		this.deliveryDate = deliveryDate;
		this.quantity = quantity;
	}





	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
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
		return "Order [orderNumber=" + id + ", deliveryPlace=" + deliveryPlace + ", deliveryDate="
				+ deliveryDate + ", quantity=" + quantity + "]";
	}





	
	
	
}
