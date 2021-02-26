package com.qa.penguins.service;

import org.springframework.stereotype.Service;

@Service
public class MediumResponseService implements ResponseService {

	@Override
	public String generateResponse() {
		return "meh";
	}

}
