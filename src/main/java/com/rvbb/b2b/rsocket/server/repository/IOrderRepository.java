package com.rvbb.b2b.rsocket.server.repository;

import com.rvbb.b2b.rsocket.server.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends CrudRepository<OrderEntity, Long> {
}
