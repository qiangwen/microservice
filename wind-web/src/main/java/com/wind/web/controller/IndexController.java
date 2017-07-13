package com.wind.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 * @author qiang.wen
 * @date 2017年7月7日 下午5:28:52
 */
@RestController
@RequestMapping("/")
public class IndexController {
	
	/**
	 * 首页
	 * @return
	 * @author qiang.wen
	 * @date 2017年7月7日 下午5:49:30
	 */
	@RequestMapping("/index")
	public String index(){
		return "欢迎来到微服务web端";
	}
}
