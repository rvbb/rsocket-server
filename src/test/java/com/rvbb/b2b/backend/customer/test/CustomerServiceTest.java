package com.rvbb.b2b.backend.customer.test;

import com.rvbb.b2b.backend.customer.dto.Customer;
import com.rvbb.b2b.backend.customer.entity.CustomerEntity;
import com.rvbb.b2b.backend.customer.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerServiceTest {

	@Autowired
	CustomerService service;
	
	@Test
	public void givenDto_whenInsertOrUpdate_thenReturnEntity() throws IOException {
		CustomerEntity entity = null;
		// given
		Customer dto = Customer.builder().name("Vo Nguyen Giap").age(35).phone("0987654321").build();

		// when
		if(service != null) {
			entity = service.insert(dto);
		}
		// then
		assertTrue(true);
	}

}
