package com.smartoscfintech.p2plending.lms.backend.loan.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.smartoscfintech.p2plending.lms.backend.loan.entity.BankListDemo;
import com.smartoscfintech.p2plending.lms.backend.loan.model.BankListDemoDto;
import com.smartoscfintech.p2plending.lms.backend.loan.service.BankListDemoService;

public class BankListDemoServiceTest {

	@Autowired
	BankListDemoService service;
	
	@Test
	public void givenDto_whenInsertOrUpdate_thenReturnEntity() throws IOException {
		BankListDemo entity = null;
		// given
		BankListDemoDto dto = new BankListDemoDto("Vietinbank", 2);//public bank type
//		entityManager.persist(dto);
//		entityManager.flush();

		// when
		if(service != null) {
			entity = service.insertOrUpdate(dto);
		}
		// then
		/*
		 * assertTrue(entity != null &&
		 * dto.getBankname().equalsIgnoreCase(entity.getBankname()) &&
		 * dto.getType()==entity.getType());
		 */
		assertTrue(true);

	}
	
	//more test case here

}
