package com.wgb.spring.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author INNERPEACE
 * @date 2020/6/2 15:58
 */
@RestController
@Slf4j
public class ProviderTwoController {
	@RequestMapping("spaceX/info")
	public String providerOneSpaceXInfo(@RequestParam("id") String spaceXId) {
		log.info("provider2获取数据：spaceXid={}", spaceXId);
		return "provider2" + spaceXId;
	}
}
