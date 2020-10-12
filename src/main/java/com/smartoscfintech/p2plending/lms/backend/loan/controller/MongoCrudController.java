package com.smartoscfintech.p2plending.lms.backend.loan.controller;

import java.util.List;

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
import com.smartoscfintech.p2plending.lms.backend.loan.model.CrudDto;
import com.smartoscfintech.p2plending.lms.backend.loan.model.FailureResponse;
import com.smartoscfintech.p2plending.lms.backend.loan.service.MongoCrudService;
import com.smartoscfintech.p2plending.lms.backend.loan.entity.Crud;

@Slf4j
@RestController
@RequestMapping(path = "/mongocrud/")
@Api(value = "MongoDB CRUD Controller")
public class MongoCrudController {

	@Autowired
	MongoCrudService service;

	 /**
	 * Get all Crud records
	 * Metdho = Get    
	 */
	@ApiOperation(value = "Listing all Crud rows")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "crud row fechted success", response = Crud.class),
			@ApiResponse(code = 400, message = "Bad request", response = FailureResponse.class) })
	@GetMapping(value = "/all")
	@Cacheable("crudList")
	public List<Crud> all() {
		return service.list();
	}

	 /**
     * Create new a crud with DTO directly
     * Method = POST    
     */
	@PostMapping(value = "/create")
	public Crud create(@RequestBody CrudDto dto) {
		return service.upsert(dto);
	}

	/**
	 * Update a existed crud with DTO directly
	 * Method = POST    
	 */
	@PostMapping(value = "/{id}/update")
	public Crud update(@RequestBody CrudDto dto, @PathVariable(required = true) String id) {
		dto.setId(id);
		return service.upsert(dto);
	}
	 /**
     * Get a crud by ID
     * Method = Get
     *     
     **/
	@ApiOperation(value = "Get one Crud by id", notes = "id is mandatory")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "got success", response = Crud.class),
			@ApiResponse(code = 400, message = "Bad request", response = FailureResponse.class),
			@ApiResponse(code = 404, message = "Not Found Exception", response = FailureResponse.class)
			/*
			 * @ApiResponse(code = 500, message = "Internal Server Error", response =
			 * FailureResponse.class)
			 */ })
	@ResponseBody	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Cacheable("crud")
	public Crud get(@PathVariable(required = true) String id) {
		return service.get(id);
	}

	 /**
     * Remove a crud by ID
     * Method = DELETE
     *     
     **/
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Delete success", response = Crud.class),
			@ApiResponse(code = 400, message = "Bad request", response = FailureResponse.class)})
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) String id) {
		service.delete(id);
	}
	
	 /**
     * Evict banklist from cache. Use this method with any data changed.;
     *     
     */
    @CacheEvict(cacheNames = {"crudList", "crud"}, allEntries = true)
    @RequestMapping(path = "/cache/evict", method = RequestMethod.DELETE)
    @ApiOperation(value = "Evict Crud cache")
    public void evictCache() {
        log.info("crud cache has been evicted");
    }
}
