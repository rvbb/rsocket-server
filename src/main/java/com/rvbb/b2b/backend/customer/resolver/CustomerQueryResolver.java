package com.rvbb.b2b.backend.customer.resolver;

import com.rvbb.b2b.backend.customer.entity.CustomerEntity;
import com.rvbb.b2b.backend.customer.service.CustomerService;
import com.rvbb.b2b.backend.customer.util.SMFLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
//@Component
public class CustomerQueryResolver/* implements GraphQLQueryResolver*/ {

    @Autowired
    CustomerService customerService;

    @SMFLogger
    public CustomerEntity getCustomerOne(Long id) {
        return customerService.getCustomerById(id);
    }

    @SMFLogger
    public List<CustomerEntity> getCustomers() {
        return customerService.list();
    }
}
