package com.qa.penguins.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.penguins.domain.Penguin;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // loads the context
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:penguin-schema.sql",
		"classpath:penguin-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class PenguinControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	// RUN SCRIPTS -> RUN TEST -> RUN SCRIPTS -> RUN TEST -> REPEAT

	@Test
	void testCreate() throws Exception {
		// create penguin
		Penguin newPenguin = new Penguin("Pingu", 45, 0, 64);
		// convert it to json string
		String newPenguinAsJSON = this.mapper.writeValueAsString(newPenguin);
		// build mock request
		RequestBuilder mockRequest = post("/createPenguin").contentType(MediaType.APPLICATION_JSON)
				.content(newPenguinAsJSON);

		// create "saved" penguin
		Penguin savedPenguin = new Penguin(2L, "Pingu", 45, 0, 64);
		// convert "saved" penguin to json
		String savedPenguinAsJSON = this.mapper.writeValueAsString(savedPenguin);

		// check status is 201 - CREATED
		ResultMatcher matchStatus = status().isCreated();
		// check that response body is correct penguin
		ResultMatcher matchBody = content().json(savedPenguinAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

//		FOR DEMO PURPOSES:
//		this.mockMVC
//				.perform(post("/createPenguin").contentType(MediaType.APPLICATION_JSON)
//						.content(this.mapper.writeValueAsString(new Penguin("Pingu", 45, 0, 64))))
//				.andExpect(status().isCreated())
//				.andExpect(content().json(this.mapper.writeValueAsString(new Penguin(1L, "Pingu", 45, 0, 64))));
	}

	@Test
	void readTest() throws Exception {
		Penguin testPenguin = new Penguin(1L, "Oswald", 4, 0, 65);
		List<Penguin> allPenguins = List.of(testPenguin);
		String testPenguinAsJSON = this.mapper.writeValueAsString(allPenguins);

		RequestBuilder mockRequest = get("/getPenguins");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testPenguinAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
	}
}
