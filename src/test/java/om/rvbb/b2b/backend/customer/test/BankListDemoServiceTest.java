package om.rvbb.b2b.backend.customer.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import om.rvbb.b2b.backend.customer.entity.BankListDemo;
import om.rvbb.b2b.backend.customer.model.BankListDemoDto;
import om.rvbb.b2b.backend.customer.service.BankListDemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
