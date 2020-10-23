package com.rvbb.b2b.rsocket.server.service;

import com.rvbb.b2b.rsocket.server.dto.request.OrderRequest;
import com.rvbb.b2b.rsocket.server.entity.OrderEntity;
import com.rvbb.b2b.rsocket.server.exception.NotFoundException;
import com.rvbb.b2b.rsocket.server.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
	
	@Autowired 
	private IOrderRepository repository;

	public OrderEntity insertOne(OrderRequest dto) {
		return repository.save(toEntity(dto));
	}

	public OrderEntity getOne(Long id) {
		Optional<OrderEntity> order = repository.findById(id);
		return order.orElseThrow(() -> new NotFoundException("Order with id: " + id + " could not discovered"));
	}

	public OrderEntity update(OrderRequest customer, Long id) {
		OrderEntity entity = toEntity(customer);
		entity.setId(id);
		return repository.save(entity);
	}

	public List<OrderEntity> list() {
		return (List<OrderEntity>) repository.findAll();
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	private OrderEntity toEntity(OrderRequest dto) {
		OrderEntity entity = new OrderEntity();
		entity.setOrderDate(dto.getOrderDate());
		entity.setTotal(dto.getTotal());
		entity.setCustomerId(dto.getCustomerId());
		return entity;
	}

}
