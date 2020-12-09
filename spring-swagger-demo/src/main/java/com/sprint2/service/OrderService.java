package com.sprint2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint2.model.Order;
import com.sprint2.repository.OrderRepository;

@Service
public class OrderService implements IOrderService{
	@Autowired
	private OrderRepository orderRepo;
	public List<Order> getAllOrders() {

		
		return orderRepo.findAll();
	}

	// get Participants by id
	public Order getOrderById(int id) {

		return orderRepo.findById(id).orElse(null);

	}
	// return participantDao.findById(id).orElse(new Participant());

	// Add Participants
	public int addOrder(Order order) {

		if (orderRepo.existsById(order.getId())) {

			return 0;
		} else {

			return orderRepo.save(order).getId();

		}
	}

	// Update Participants
	public Order updateOrder(Order order) {
		if (orderRepo.existsById(order.getId())) {
			return orderRepo.save(order);

		} else {
			return new Order();
		}
	}

	// Remove Participants
	public boolean removeOrderbyId(int id) {
		if (orderRepo.existsById(id)) {
			orderRepo.deleteById(id);
			return true;
		} else {
			return false;
		}

	}


}
