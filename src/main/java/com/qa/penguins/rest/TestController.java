package com.qa.penguins.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.penguins.service.test.ResponseService;

@RestController
public class TestController {

	private ResponseService service;

	public TestController(ResponseService service) {
		super();
		this.service = service;
	}

	@GetMapping("/test")
	public String hello() {
		return this.service.generateResponse();
	}

}
