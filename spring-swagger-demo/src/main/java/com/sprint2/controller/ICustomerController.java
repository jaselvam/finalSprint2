package com.sprint2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprint2.model.Customer;

public interface ICustomerController {
	public @ResponseBody List<Customer> servicegetAllCustomer();
	public @ResponseBody    Customer servicegetCustomerById(@PathVariable int customerId);
	public  @ResponseBody  Customer serviceaddCustomer(@RequestBody Customer customer);
	public @ResponseBody  Customer serviceupdateCustomer(@RequestBody Customer customer);
	public @ResponseBody  String serviceremoveCustomer(@PathVariable int customerId);
	public ResponseEntity<Customer> getCustomerByemailId(@PathVariable String customerEmail );
	
}
