package com.apipothi.logexample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogingController {

	private final static Logger logger = LoggerFactory.getLogger(LogingController.class);

	@RequestMapping("/")
	public String getlogs() {

		logger.error("i am error");
		logger.warn("i am warning");
		logger.info("i am info");
		logger.debug("i am debug");
		logger.trace("i am trace");
		
		return "welcome to shubhams code";
	}

}
