package com.qa.penguins.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.penguins.domain.Penguin;

@RestController
public class PenguinController {

	private List<Penguin> penguins = new ArrayList<>();

	@PostMapping("/createPenguin")
	public void createPenguin(@RequestBody Penguin penguin) {
		this.penguins.add(penguin);
	}

	@GetMapping("/getPenguins")
	public List<Penguin> getPenguin() {
		return this.penguins;
	}

	@GetMapping("/getPenguin/{id}")
	public Penguin getPenguinById(@PathVariable int id) {
		return this.penguins.get(id);
	}

	@DeleteMapping("/removePenguin/{id}")
	public Penguin removePenguin(@PathVariable int id) {
		return this.penguins.remove(id);
	}

}
