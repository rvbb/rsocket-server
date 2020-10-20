package com.rvbb.b2b.backend.customer.test;

import com.rvbb.b2b.backend.customer.dto.Customer;
import com.rvbb.b2b.backend.customer.entity.CustomerEntity;
import com.rvbb.b2b.backend.customer.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	CustomerService service;
	
	@Test
	public void givenDto_whenInsert_thenReturnEntity() throws IOException {
		CustomerEntity entity = null;
		// given
		Customer dto = Customer.builder().name("Vo Nguyen Giap").age(new Random().nextInt()).phone("00000").build();

		// when
		if(service != null) {
			entity = service.insert(dto);
		}
		// then
		assertTrue(entity != null && entity.getId() != null);
	}

}
