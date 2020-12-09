package com.sprint2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.sprint2.model.Order;
import com.sprint2.repository.OrderRepository;
import com.sprint2.service.*;



//connect from postman as http://localhost:8080/swagger-ui.html
@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/fms/m5")
public class OrderController implements IOrderController{
	
	@Autowired
	private OrderService orderservice;
	
	@GetMapping(value = {"/orders" })
	public @ResponseBody List<Order> getAllOrders() 
	{ 
		
		List<Order> order = orderservice.getAllOrders();
		
		return order;
	}
	@GetMapping("/orders/{id}")
	public  ResponseEntity<Order> getOrderById(@PathVariable int id) {
	if(orderservice.getOrderById(id)==null)
	{
		throw new ResourceNotFoundException("Record not found with id:"+id);
	}
	else
	{
		return new ResponseEntity<Order>(orderservice.getOrderById(id),HttpStatus.OK);
	}
	}
	@PostMapping("/orders")
	public ResponseEntity<Order> addOrder(@RequestBody Order order)
	{
		int id=orderservice.addOrder(order);
		if(id!=0)
		{
			return new ResponseEntity<Order>(orderservice.getOrderById(id),HttpStatus.OK);
		}
		else
		{
			throw new ResourceNotFoundException("ID already exists");
		}
	}
	@PutMapping("/orders/{id}")
	public  ResponseEntity<Order> updateOrder(@RequestBody Order order) 
	{
		if(orderservice.updateOrder(order).getId()==0)
		{
			throw new ResourceNotFoundException("Record not found");
		}
		else {
			return new ResponseEntity<Order>(orderservice.updateOrder(order),HttpStatus.OK);
		}
	}
	
		
	@DeleteMapping("/orders/{id}")
	public  ResponseEntity<Order> removeOrder(@PathVariable int id) 
	{
		Order order=orderservice.getOrderById(id);
		if(orderservice.removeOrderbyId(id))
		{
			return new ResponseEntity<Order>(order,HttpStatus.OK);
		}
		else
		{
			System.out.println("No Record is found");
			throw new ResourceNotFoundException("Record not found with id:"+id);
		}
	}

	
	
	
	
	
	
	
}

