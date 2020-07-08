package com.wgb.spring.cloud;

import feign.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author INNERPEACE
 * @date 2020/6/2
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerApplication extends SpringBootServletInitializer implements WebMvcConfigurer {
	/**
	 * 使用ribbon负载功能
	 * @return
	 */
	@Bean
	@LoadBalanced()
	public RestTemplate restTemplate() {
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setReadTimeout(30000);
		httpRequestFactory.setConnectTimeout(5000);
		return new RestTemplate(httpRequestFactory);
	}

	@Bean
	public Request.Options requestOptions(ConfigurableEnvironment env) {
		int ribbonReadTimeout = env.getProperty("ribbon.ReadTimeout", int.class, 10000);
		int ribbonConnectionTimeout = env.getProperty("ribbon.ConnectTimeout", int.class, 10000);
		return new Request.Options(ribbonConnectionTimeout, ribbonReadTimeout);
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseRegisteredSuffixPatternMatch(true);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ConsumerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
