package com.wind.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wind.web.api.UserClientApi;

/**
 * FIX：
 * 1、使用fegin接口调用远程服务
 * @author qiang.wen
 * @date 2017年7月24日 下午2:03:29
 */
@RestController
@RequestMapping("/user")
public class UserFeginClientController {
	
	@Autowired
	private UserClientApi userClientApi;

	@RequestMapping(path="/fegin/getuname",method=RequestMethod.GET)
	public String getUsername(@RequestParam("userId")int userId){
		String username = userClientApi.getUserName(userId);
		return username;
	}
	
	@RequestMapping(path="/feign/getsimplename/{id}",method=RequestMethod.GET)
	public String getSimplename(@PathVariable("id") int id){
		String username = userClientApi.getUserSimplename(id);
		return username;
	}
}
