package com.wind.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

/**
 * fix:
 * 1、通过eurekaClient来查找地址
 * 2、通过restTemplate来调用接口
 * NOTE:使用该接口需要把WebApplcation.restTemplate()方法上的@LoadBalanced去除
 * @author qiang.wen
 * @date 2017年7月12日 下午4:32:58
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	/**
	 * 获取用户名称
	 * @param userId
	 * @return
	 * @author qiang.wen
	 * @date 2017年7月7日 下午5:18:31
	 */
	@RequestMapping(path="/getuname",method=RequestMethod.GET)
	public String getUsername(@RequestParam("userId")int userId){
		String contextPath = getContextPath();
		String path = contextPath + "user/getusername";
		//----1、在路径后直接带参数
		String username = restTemplate.getForObject(path + "?userId="+userId, String.class);
		return username;
	}
	
	@RequestMapping(path="/getsimplename/{id}",method=RequestMethod.GET)
	public String getSimplename(@PathVariable("id") int id){
		String contextPath = getContextPath();
		String path = contextPath + "user/getsimplename/{id}";
		//----1、使用Map传递参数
//		Map<String,Object> map = new HashMap<>();
//		map.put("id", id);
//		String username = restTemplate.getForObject(path, String.class, map);
		//----2、使用Object[]传递参数
		String username = restTemplate.getForObject(path, String.class, 7);
		return username;
	}
	
	private String getContextPath(){
		//通过eurekaclient获取实例
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("userservice", false);
		String url = instance.getHomePageUrl();
		return url;
	}
	
	
}
