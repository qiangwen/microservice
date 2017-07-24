package com.wind.web.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * web应用服务器
 * @author qiang.wen
 * @date 2017年7月7日 下午5:26:19
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.wind.web"})
@EnableEurekaClient
@EnableFeignClients(basePackages={"com.wind.web.api"})
public class WebApplcation {
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	public static void main(String[] args) {
		SpringApplication.run(WebApplcation.class, args);
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		return restTemplateBuilder.build();
	}
}
