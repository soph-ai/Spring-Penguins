package com.qa.penguins.service.test;

import org.springframework.stereotype.Service;

@Service
public class MediumResponseService implements ResponseService {

	@Override
	public String generateResponse() {
		return "meh";
	}

}
