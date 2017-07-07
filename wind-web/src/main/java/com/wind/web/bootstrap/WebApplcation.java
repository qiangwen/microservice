package com.wind.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * web应用服务器
 * @author qiang.wen
 * @date 2017年7月7日 下午5:26:19
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.wind.web"})
@EnableEurekaClient
public class WebApplcation {

	public static void main(String[] args) {
		SpringApplication.run(WebApplcation.class, args);
	}
}
