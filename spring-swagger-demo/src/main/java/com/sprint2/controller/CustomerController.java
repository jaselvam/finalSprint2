package com.sprint2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprint2.Exceptions.ResourceNotFoundException;
import com.sprint2.model.Customer;
import com.sprint2.repository.CustomerRepository;
import com.sprint2.service.CustomerService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/fms/m3")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping(value= {"/customers"})
	public @ResponseBody List<Customer> servicegetAllCustomer()
	{
		
		List<Customer> customer =customerService.servicegetAllCustomer();
		
		return customer;
		
	}
	@GetMapping("/customers/{customerId}")
	public @ResponseBody    Customer servicegetCustomerById(@PathVariable int customerId)
	{
		
		return customerService.servicegetCustomerById(customerId);
	}
	@PostMapping("/customers")
	public  @ResponseBody  Customer serviceaddCustomer(@RequestBody Customer customer)
	{
		
		return customerService.serviceaddCustomer(customer);
		
	}
	
	//creating a put mapping that updates  the  Customer detail
	@PutMapping("/customers/{customerId}")
	public @ResponseBody  Customer serviceupdateCustomer(@RequestBody Customer customer)
	{
		
		return customerService.serviceupdateCustomer( customer);
	
	}
	
	//creating a delete  mapping that delete  the  details of the specific Customer
	@DeleteMapping("/customers/{customerId}")
	public @ResponseBody  String serviceremoveCustomer(@PathVariable int customerId)
	{
		
		return customerService.serviceremoveCustomer(customerId);
	}
	/*@GetMapping("/customers")
	public List<Customer> servicegetAllCustomer()
	{
		
		return customerRepository.findAll();
	}
	
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer)
	{
		return customerRepository.save(customer);
	}
	
	//creating a put mapping that updates  the  Customer detail
	@PutMapping("/customers/{customerId}")
	public ResponseEntity<Customer> serviceupdateCustomer(@PathVariable Long customerId ,@RequestBody Customer customer)
	{
		Customer customer1 = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("customer not exist with id :" + customerId));
		customer1.setCustomerName(customer.getCustomerName());
		customer1.setCustomerPassword(customer.getCustomerPassword());
		customer1.setCustomerEmail(customer.getCustomerEmail());
		customer1.setCustomerAddress(customer.getCustomerAddress());
		customer1.setCustomerContact(customer.getCustomerContact());
		customer1.setCustomerPostalcode(customer.getCustomerPostalcode());
		customer1.setCustomerTown(customer.getCustomerTown());
		
		Customer updatedCustomer=customerRepository.save(customer1);
		return ResponseEntity.ok(updatedCustomer);
	
	}
	
	
	
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<Map<String,Boolean>> deleteCustomer(@PathVariable Long customerId)
	{
		Customer customer1 = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("customer not exist with id :" + customerId));
		customerRepository.delete(customer1);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}*/
	
	@GetMapping("/customer/{customerEmail}")
	public ResponseEntity<Customer> getCustomerByemailId(@PathVariable String customerEmail ) {
		List<Customer> cust = customerRepository.findAll();
		for(Customer d:cust) {
			
			if(d.getCustomerEmail().equals(customerEmail))
				
				return ResponseEntity.ok(d);	
		}
		return null;
		
	}
	
}
