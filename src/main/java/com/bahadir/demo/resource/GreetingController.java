package com.bahadir.demo.resource;

import com.bahadir.demo.Service.GreetingService;
import com.bahadir.demo.model.AccountType;
import com.bahadir.demo.model.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/")
@Api(value="UserResources", consumes="application/json", produces="application/json", description="Greeting operations")
public class GreetingController {

	@Autowired
	private GreetingService greetingService;

	
	@GetMapping("/greeting")
	@ApiOperation(consumes="application/json", produces="application/json", value = "getUser" )
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Not implemented")
	})	
	public String greet(@RequestParam(name = "account") AccountType accountType,
						@RequestParam(name = "type", required = false) BusinessType businessType,
						@RequestParam(name = "id", required = false) Integer id) {
		return greetingService.getUser(accountType, businessType, id);
	}


}
