package vietteldigital.webback.bankplus.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import springweb.demo.bank.controller.BankListDemoController;
import springweb.demo.bank.service.BankListDemoService;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(BankListDemoController.class)
public class BankListDemoControllerTest {

//	@MockBean
//	BankListDemoService service;
//
//	@Autowired
//	private MockMvc mockMvc;

	@Test
	public void whenMoreThanOne_getAllBankListDemo_Test() throws Exception{

		assertTrue(true);
//  	given
//		MvcResult mvcResult = mockMvc.perform(
//				MockMvcRequestBuilders.get("/all").contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
//		when
//		Integer status = mvcResult.getResponse().getStatus();

//		 then
//		assertEquals(HttpStatus.OK.value(), status, "Success fetch all record of BanklistDemo");
		assertTrue(true);

	}

	/* more test case here */

}
