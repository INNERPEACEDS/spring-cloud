package com.wgb.spring.cloud.controller;

import com.wgb.spring.cloud.facade.SpaceXFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author INNERPEACE
 * @date 2020/6/2
 */
@RestController
@Slf4j
public class ConsumerController {

	@Autowired
	private SpaceXFacade spaceXFacade;

	@RequestMapping("getSpaceX")
	public String getSpaceX(String nCount) {
		log.info("请求参数nCount={}", nCount);
		return spaceXFacade.getSpaceXInfo(nCount);
	}
}
