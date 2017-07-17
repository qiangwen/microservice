package com.wind.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * fix:
 * 1、使用Ribbon做客户端负载均衡，通过在生成restTempate的时候加上注解@@LoadBalanced实现
 * NOTE:使用该接口需要在WebApplcation.restTemplate()方法上加上@LoadBalanced注解
 * 用户服务
 * @author qiang.wen
 * @date 2017年7月12日 下午4:32:58
 */
@RestController
@RequestMapping("/user")
public class UserBalanceTemplateController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping(path="/ribbon/template/getuname",method=RequestMethod.GET)
	public String getUsernameForRibbon(@RequestParam("userId")int userId){
		String path = "http://userservice/user/getusername";
		//----1、在路径后直接带参数
		String username = restTemplate.getForObject(path + "?userId="+userId, String.class);
		return username;
	}
	
	@RequestMapping(path="/ribbon/template/getsimplename/{id}",method=RequestMethod.GET)
	public String getSimplenameForRibbon(@PathVariable("id") int id){
		String path = "http://userservice/user/getsimplename/{id}";
		//----1、使用Map传递参数
//		Map<String,Object> map = new HashMap<>();
//		map.put("id", id);
//		String username = restTemplate.getForObject(path, String.class, map);
		//----2、使用Object[]传递参数
		String username = restTemplate.getForObject(path, String.class, 7);
		return username;
	}
	
}
