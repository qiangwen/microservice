package com.wind.web.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="userservice",path="/user")
public interface UserClientApi {

	@RequestMapping(path="/getusername",method=RequestMethod.GET)
	String getUserName(@RequestParam("userId") int userId);
	
	@RequestMapping(path="/getsimplename/{id}",method=RequestMethod.GET)
	String getUserSimplename(@PathVariable("id") int id);
}
