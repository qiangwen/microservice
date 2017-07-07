package com.wind.userservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户类
 * @author qiang.wen
 * @date 2017年7月7日 下午5:15:43
 */
@RestController
@RequestMapping("/user")
public class UserController {

	
	/**
	 * 获取用户名称
	 * @param userId
	 * @return
	 * @author qiang.wen
	 * @date 2017年7月7日 下午5:18:31
	 */
	@RequestMapping(path="/getusername",method=RequestMethod.POST)
	public String getUsername(@RequestParam("userId")int userId){
		return "name" + userId;
	}
}
