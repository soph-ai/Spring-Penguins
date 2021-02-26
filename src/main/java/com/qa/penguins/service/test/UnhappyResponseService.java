package com.qa.penguins.service.test;

public class UnhappyResponseService implements ResponseService {

	@Override
	public String generateResponse() {
		return "Life is pain";
	}
}
