package com.rvbb.b2b.backend.customer.resolver;

import com.rvbb.b2b.backend.customer.dto.Customer;
import com.rvbb.b2b.backend.customer.dto.DetailOrder;
import com.rvbb.b2b.backend.customer.dto.request.OrderRequest;
import com.rvbb.b2b.backend.customer.dto.response.CustomizedCustomerResponse;
import com.rvbb.b2b.backend.customer.entity.CustomerEntity;
import com.rvbb.b2b.backend.customer.entity.OrderEntity;
import com.rvbb.b2b.backend.customer.exception.NotFoundException;
import com.rvbb.b2b.backend.customer.service.CustomerService;
import com.rvbb.b2b.backend.customer.service.OrderService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class CustomerOrderResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerService customerService;

    public OrderEntity createOneOrder(Date orderDate, Float total, Long customerId) {
        OrderRequest request = OrderRequest.builder().orderDate(orderDate).total(total).customerId(customerId).build();
        return orderService.insertOne(request);
    }

    public DetailOrder getDetailOrder(Long orderId) {
        //should use HQL to get enough data or get part then collect them
        OrderEntity orderEntity = orderService.getOne(orderId);
        if (ObjectUtils.isEmpty(orderEntity) || orderEntity.getCustomerId() == null) {
            throw new NotFoundException("OrderEntity or customerId field is null/invalid format");
        }
        CustomerEntity customerEntity = customerService.getCustomerById(orderEntity.getCustomerId());
        return DetailOrder.builder()
                .id(orderEntity.getId())
                .orderDate(orderEntity.getOrderDate())
                .total(orderEntity.getTotal())
                .cust(CustomizedCustomerResponse.of(customerEntity))
                .build();
    }

}
