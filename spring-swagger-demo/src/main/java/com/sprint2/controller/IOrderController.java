package com.sprint2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprint2.model.Order;

public interface IOrderController {
	public @ResponseBody List<Order> getAllOrders();
	public  ResponseEntity<Order> getOrderById(@PathVariable int id);
	public ResponseEntity<Order> addOrder(@RequestBody Order order);
	public  ResponseEntity<Order> updateOrder(@RequestBody Order order) ;
	public  ResponseEntity<Order> removeOrder(@PathVariable int id);
}
