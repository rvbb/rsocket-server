package com.smartoscfintech.p2plending.lms.backend.loan.controller;

import java.util.List;

import com.smartoscfintech.p2plending.lms.backend.loan.model.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import com.smartoscfintech.p2plending.lms.backend.loan.model.FailureResponse;
import com.smartoscfintech.p2plending.lms.backend.loan.entity.Transaction;
import com.smartoscfintech.p2plending.lms.backend.loan.service.TransactionService;

@Slf4j
@RestController
@RequestMapping(path = "/bank/transaction")
@Api(value = "Transaction Controller")
public class TransactionController {

	@Autowired
	TransactionService service;

	@ApiOperation(value = "Listing all transactions")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "all transaction be fechted success", response = Transaction.class),
			@ApiResponse(code = 400, message = "Bad request", response = FailureResponse.class) })
	@GetMapping
	@Cacheable("transactions")
	public List<Transaction> allTransactions() {
		return service.list();
	}

	@ApiOperation(value = "Create new one")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "create success", response = Transaction.class),
			@ApiResponse(code = 400, message = "Bad request", response = FailureResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = FailureResponse.class)})
	@PostMapping
	@Cacheable("transactionCreate")
	public Transaction createOne(TransactionDto dto) {
		return service.insertOne(dto);
	}

	/**
	 * Evict transaction from cache. Use this method with any data changed.;
	 * 
	 */
	@CacheEvict(cacheNames = { "transactions", "transactionCreate" }, allEntries = true)
	@RequestMapping(path = "/cache/evict", method = RequestMethod.DELETE)
	@ApiOperation(value = "Evict transactions cache")
	public void evictCache() {
		log.info("accounts cache has been evicted");
	}

	/* more api here */
}
