package com.rvbb.b2b.backend.customer.resolver;

import com.rvbb.b2b.backend.customer.dto.Customer;
import com.rvbb.b2b.backend.customer.entity.CustomerEntity;
import com.rvbb.b2b.backend.customer.service.CustomerService;
import com.rvbb.b2b.backend.customer.util.SMFLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class CustomerMutationResolver /*implements GraphQLMutationResolver*/ {

    @Autowired
    CustomerService customerService;

    @SMFLogger
    public CustomerEntity createOneCustomer(String name, String phone, int age) {
        Customer customer = Customer.builder().name(name).phone(phone).age(age).build();
        return customerService.insert(customer);
    }

    @SMFLogger
    public CustomerEntity createOneCustomerFromDto(Customer customerRequest) {
        return customerService.insert(customerRequest);
    }

    @SMFLogger
    public CustomerEntity updateOneCustomer(String name, String phone, int age, Long id) {
        Customer customer = Customer.builder().name(name).phone(phone).age(age).build();
        return customerService.update(customer, id);
    }
}
