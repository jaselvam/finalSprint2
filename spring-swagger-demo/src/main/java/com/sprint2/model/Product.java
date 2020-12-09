package com.sprint2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//mark class as an Entity
@Entity

//defining class name as Table name
@Table(name="Products_78")
public class Product {
	
	// Defining product id as primary key
	@Id
	@GeneratedValue
	private Integer productId;
	private String productName;
	private String productQuanity;
	private String productDescription;
	
	
	public Product() {
		
	}
	public Product(Integer productId, String productName, String productQuanity, String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQuanity = productQuanity;
		this.productDescription = productDescription;
	}
	public Product(String productName, String productQuanity, String productDescription) {
		super();
		this.productName = productName;
		this.productQuanity = productQuanity;
		this.productDescription = productDescription;
	}


	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductQuanity() {
		return productQuanity;
	}


	public void setProductQuanity(String productQuanity) {
		this.productQuanity = productQuanity;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productQuanity=" + productQuanity
				+ ", productDescription=" + productDescription + "]";
	}
	
	
	
}