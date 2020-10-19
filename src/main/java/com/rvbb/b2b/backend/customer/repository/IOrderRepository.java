package com.rvbb.b2b.backend.customer.repository;

import com.rvbb.b2b.backend.customer.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends CrudRepository<OrderEntity, String> {
}
