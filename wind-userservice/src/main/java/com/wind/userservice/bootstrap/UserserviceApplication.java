package com.wind.userservice.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 用户service application
 * @author qiang.wen
 * @date 2017年7月7日 下午2:26:38
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.wind.userservice"})
@EnableEurekaClient
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}
}
