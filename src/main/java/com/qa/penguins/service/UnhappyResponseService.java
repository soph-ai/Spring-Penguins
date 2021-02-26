package com.qa.penguins.service;

public class UnhappyResponseService implements ResponseService {

	@Override
	public String generateResponse() {
		return "Life is pain";
	}
}
