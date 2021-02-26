package com.qa.penguins.service.test;

public class HappyResponseService implements ResponseService {

	@Override
	public String generateResponse() {
		return "Hello, World!";
	}

}
