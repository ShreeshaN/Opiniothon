package com.venturesity.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping( value = "/home", method = RequestMethod.GET )
	public void test()
	{
		log.info("Hello world");
	}

}
