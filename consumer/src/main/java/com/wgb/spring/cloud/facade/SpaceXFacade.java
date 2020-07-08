package com.wgb.spring.cloud.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author INNERPEACE
 * @date 2020/6/2
 */

@FeignClient(value = "provider-name")
public interface SpaceXFacade {

	/**
	 * 获取SpaceX发射信息
	 * @PostMapping 对应服务提供者中Controller层对外提供的接口（提供者是Post就用Post，是Get就用Get，要对应）
	 * @return
	 */
	@PostMapping(value = "/spaceX/info")
	String getSpaceXInfo(@RequestParam("id")String id);
}
