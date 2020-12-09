package com.sprint2.service;

import java.util.List;

import com.sprint2.model.Customer;

public interface ICustomerService {
	public List<Customer> servicegetAllCustomer();
	public Customer servicegetCustomerById(int customerId);
	public Customer serviceaddCustomer(Customer customer);
	public Customer serviceupdateCustomer(Customer customer);
	public String serviceremoveCustomer(int customerId) ;
	
}
