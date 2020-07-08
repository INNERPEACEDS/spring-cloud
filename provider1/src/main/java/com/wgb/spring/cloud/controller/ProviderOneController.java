package com.wgb.spring.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author INNERPEACE
 * @date 2020/6/2 15:58
 */
@RestController
@Slf4j
public class ProviderOneController {
	/**
	 * 向consul中注册接口信息配置在application.yml文件中（包含服务提供者的服务名称，向具体的consul地址发布等）
	 * @param spaceXId
	 * @return
	 */
	@PostMapping("spaceX/info")
	public String providerOneSpaceXInfo(@RequestParam("id") String spaceXId) {
		log.info("provider1获取数据：spaceXid={}", spaceXId);
		return "provider1" + spaceXId;
	}
}
