package com.wind.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * FIX:
 * 1、使用LoadBalancerClient来实现负载均衡
 * NOTE:使用该接口需要把WebApplcation.restTemplate()方法上的@LoadBalanced去除
 * 
 * 用户服务
 * @author qiang.wen
 * @date 2017年7月12日 下午4:32:58
 */
@RestController
@RequestMapping("/user")
public class UserRibbonClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	
	@RequestMapping(path="/ribbon/getuname",method=RequestMethod.GET)
	public String getUsernameForRibbon(@RequestParam("userId")int userId){
		ServiceInstance instance = loadBalancerClient.choose("userservice");
		String path = String.format("http://%s:%s/%s", instance.getHost(),instance.getPort(),"user/getusername");
		//----1、在路径后直接带参数
		String username = restTemplate.getForObject(path + "?userId="+userId, String.class);
		return username;
	}
	
	@RequestMapping(path="/ribbon/getsimplename/{id}",method=RequestMethod.GET)
	public String getSimplenameForRibbon(@PathVariable("id") int id){
		ServiceInstance instance = loadBalancerClient.choose("userservice");
		String path = String.format("http://%s:%s/%s", instance.getHost(),instance.getPort(),"user/getsimplename/{id}");
		//----1、使用Map传递参数
//		Map<String,Object> map = new HashMap<>();
//		map.put("id", id);
//		String username = restTemplate.getForObject(path, String.class, map);
		//----2、使用Object[]传递参数
		String username = restTemplate.getForObject(path, String.class, 7);
		return username;
	}
	
}
