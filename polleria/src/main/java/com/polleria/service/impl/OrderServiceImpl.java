package com.polleria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polleria.entity.Order;
import com.polleria.repository.OrderRepository;
import com.polleria.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();	}

	@Override
	public Order getOneById(Long id) {
		return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order Not Found!"));

	}

	@Override
	public Long create(Order entity) {
		orderRepository.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Long id, Order entity) {
		orderRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		orderRepository.deleteById(id);
		
	}

	@Override
	public List<Order> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
