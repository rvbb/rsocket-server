package com.rvbb.b2b.backend.customer.service;

import java.util.Date;
import java.util.List;

import com.rvbb.b2b.backend.customer.dto.Customer;
import com.rvbb.b2b.backend.customer.entity.CustomerEntity;
import com.rvbb.b2b.backend.customer.repository.IOrderRepository;
import com.rvbb.b2b.backend.customer.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvbb.b2b.backend.customer.entity.OrderEntity;

@Service
public class OrderService {
	
	@Autowired 
	private IOrderRepository repository;

	public OrderEntity insertOne(Order dto) {
		return repository.save(toEntity(dto));
	}

	public OrderEntity update(Order customer, Long id) {
		OrderEntity entity = toEntity(customer);
		entity.setId(id);
		return repository.save(entity);
	}

	public List<OrderEntity> list() {
		return (List<OrderEntity>) repository.findAll();
	}

	public void delete(Long id) {
		repository.deleteById(String.valueOf(id));
	}

	private OrderEntity toEntity(Order dto) {
		OrderEntity entity = new OrderEntity();
		entity.setOrderDate(dto.getOrderDate());
		entity.setTotal(dto.getTotal());
		return entity;
	}

}
