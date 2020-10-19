package com.rvbb.b2b.backend.customer.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BankListDemoResolver implements GraphQLQueryResolver {

    public String hi(String yourName) {
        return "Hi there, " + yourName;
    }

//	@Autowired
//	BankListDemoService service;
//
//	 /**
//	 * Get all banklistdemo records
//	 * Metdho = Get
//	 */
//	@ApiOperation(value = "Listing all bank_list_demo")
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "banklistdemo list fechted success", response = BankListDemo.class),
//			@ApiResponse(code = 400, message = "Bad request", response = FailureResponse.class) })
//	@GetMapping(value = "/all")
//	@Cacheable("banklistAll")
//	public List<BankListDemo> getAllBankListDemo() {
//		return service.list();
//	}
//
//	 /**
//     * Create new a banklistdemo with DTO directly
//     * Method = POST
//     */
//	@PostMapping(value = "/new")
//	@SMFLogger
//	public BankListDemo createNew(@RequestBody BankListDemoDto dto) {
//		return service.insertOrUpdate(dto);
//	}
//
//	 /**
//     * Create new a banklistdemo vi parameters
//     * Method = POST
//     */
//	@ApiOperation(value = "Create new BankListDemo", notes = "parameters are not null")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Insert success", response = BankListDemo.class),
//			@ApiResponse(code = 400, message = "Require bankname and type parameter", response = FailureResponse.class),
//			@ApiResponse(code = 404, message = "Not Found Exception", response = FailureResponse.class)})
//	@PostMapping(value = "/newone", produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public BankListDemo createNew(@ApiParam(value = "Bankname", required = true) @RequestParam String bankname,
//			@ApiParam(value = "Type", required = true) @RequestBody Integer type) {
//
//		if(!IConst.BANKLISTDEMO_TYPES.containsKey(type))
//			throw new InternalServiceException(String.format("Type is invalid [%s]", type));
//		BankListDemoDto dto = new BankListDemoDto(bankname, type);
//		return service.insertOrUpdate(dto);
//	}
//
//	 /**
//     * Get a banklistdemo by ID
//     * Method = Get
//     *
//     **/
//	@ApiOperation(value = "Get banklistdemo by id", notes = "id is mandatory")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "got success", response = BankListDemo.class),
//			@ApiResponse(code = 400, message = "Bad request", response = FailureResponse.class),
//			@ApiResponse(code = 404, message = "Not Found Exception", response = FailureResponse.class)
//			/*
//			 * @ApiResponse(code = 500, message = "Internal Server Error", response =
//			 * FailureResponse.class)
//			 */ })
//	@ResponseBody
//	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	@Cacheable("banklist")
//	public BankListDemo getBankListDemoById(@PathVariable(required = true) long id) {
//
//		return service.getBankListDemoById(id);
//	}
//
//	 /**
//     * Remove a banklistdemo by ID
//     * Method = DELETE
//     *
//     **/
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Delete success", response = BankListDemo.class),
//			@ApiResponse(code = 400, message = "Bad request", response = FailureResponse.class)})
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable(required = true) long id) {
//		service.delete(id);
//	}
//
//	 /**
//     * Evict banklist from cache. Use this method with any data changed.;
//     *
//     */
//    @CacheEvict(cacheNames = {"bankList", "banklistAll"}, allEntries = true)
//    @RequestMapping(path = "/cache/evict", method = RequestMethod.DELETE)
//    @ApiOperation(value = "Evict banklistdemo cache")
//    public void evictCache() {
//        log.info("banklistdemo cache has been evicted");
//    }
}
