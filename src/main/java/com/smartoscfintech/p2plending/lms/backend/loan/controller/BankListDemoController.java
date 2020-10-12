package com.smartoscfintech.p2plending.lms.backend.loan.controller;

import java.util.List;

import com.smartoscfintech.p2plending.lms.backend.loan.entity.BankListDemo;
import com.smartoscfintech.p2plending.lms.backend.loan.util.IConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import com.smartoscfintech.p2plending.lms.backend.loan.exception.InternalServiceException;
import com.smartoscfintech.p2plending.lms.backend.loan.model.BankListDemoDto;
import com.smartoscfintech.p2plending.lms.backend.loan.model.FailureResponse;
import com.smartoscfintech.p2plending.lms.backend.loan.service.BankListDemoService;

@Slf4j
@RestController
@RequestMapping(path = "/bank/banklistdemo")
@Api(value = "BankListDemo Controller")
public class BankListDemoController {

	@Autowired
	BankListDemoService service;

	 /**
	 * Get all banklistdemo records
	 * Metdho = Get    
	 */
	@ApiOperation(value = "Listing all bank_list_demo")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "banklistdemo list fechted success", response = BankListDemo.class),
			@ApiResponse(code = 400, message = "Bad request", response = FailureResponse.class) })
	@GetMapping(value = "/all")
	@Cacheable("banklistAll")
	public List<BankListDemo> getAllBankListDemo() {
		return service.list();
	}

	 /**
     * Create new a banklistdemo with DTO directly
     * Method = POST    
     */
	@PostMapping(value = "/new")
	public BankListDemo createNew(@RequestBody BankListDemoDto dto) {
		return service.insertOrUpdate(dto);
	}

	 /**
     * Create new a banklistdemo vi parameters
     * Method = POST    
     */
	@ApiOperation(value = "Create new BankListDemo", notes = "parameters are not null")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Insert success", response = BankListDemo.class),
			@ApiResponse(code = 400, message = "Require bankname and type parameter", response = FailureResponse.class), 
			@ApiResponse(code = 404, message = "Not Found Exception", response = FailureResponse.class)})	
	@PostMapping(value = "/newone", produces = MediaType.APPLICATION_JSON_VALUE)	
	@ResponseBody	
	public BankListDemo createNew(@ApiParam(value = "Bankname", required = true) @RequestParam String bankname,
			@ApiParam(value = "Type", required = true) @RequestBody Integer type) {

		if(!IConst.BANKLISTDEMO_TYPES.containsKey(type))
			throw new InternalServiceException(String.format("Type is invalid [%s]", type));			
		BankListDemoDto dto = new BankListDemoDto(bankname, type);
		return service.insertOrUpdate(dto);
	}

	 /**
     * Get a banklistdemo by ID
     * Method = Get
     *     
     **/
	@ApiOperation(value = "Get banklistdemo by id", notes = "id is mandatory")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "got success", response = BankListDemo.class),
			@ApiResponse(code = 400, message = "Bad request", response = FailureResponse.class),
			@ApiResponse(code = 404, message = "Not Found Exception", response = FailureResponse.class)
			/*
			 * @ApiResponse(code = 500, message = "Internal Server Error", response =
			 * FailureResponse.class)
			 */ })
	@ResponseBody	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Cacheable("banklist")
	public BankListDemo getBankListDemoById(@PathVariable(required = true) long id) {
		
		return service.getBankListDemoById(id);
	}

	 /**
     * Remove a banklistdemo by ID
     * Method = DELETE
     *     
     **/
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Delete success", response = BankListDemo.class),
			@ApiResponse(code = 400, message = "Bad request", response = FailureResponse.class)})
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) long id) {
		service.delete(id);
	}
	
	 /**
     * Evict banklist from cache. Use this method with any data changed.;
     *     
     */
    @CacheEvict(cacheNames = {"bankList", "banklistAll"}, allEntries = true)
    @RequestMapping(path = "/cache/evict", method = RequestMethod.DELETE)
    @ApiOperation(value = "Evict banklistdemo cache")
    public void evictCache() {
        log.info("banklistdemo cache has been evicted");
    }
}
