package com.wgb.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author INNERPEACE
 * @date 2020/6/2
 */
@SpringBootApplication
@EnableFeignClients
public class Provider2 {
	public static void main(String[] args) {
		SpringApplication.run(Provider2.class, args);
	}

}
