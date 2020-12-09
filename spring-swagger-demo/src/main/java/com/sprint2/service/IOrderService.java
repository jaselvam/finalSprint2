package com.sprint2.service;

import java.util.List;

import com.sprint2.model.Order;

public interface IOrderService {
	public List<Order> getAllOrders() ;
	public Order getOrderById(int id);
	public int addOrder(Order order);
	public Order updateOrder(Order order);
	public boolean removeOrderbyId(int id);
	
}
