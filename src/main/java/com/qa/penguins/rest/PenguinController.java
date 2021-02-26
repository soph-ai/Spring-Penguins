package com.qa.penguins.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.penguins.domain.Penguin;
import com.qa.penguins.service.PenguinService;

@RestController
public class PenguinController {

	private PenguinService service;

	public PenguinController(PenguinService service) {
		super();
		this.service = service;
	}

	@PostMapping("/createPenguin")
	public ResponseEntity<Penguin> createPenguin(@RequestBody Penguin penguin) {
		return new ResponseEntity<Penguin>(this.service.createPenguin(penguin), HttpStatus.CREATED);
	}

	@GetMapping("/getPenguins")
	public ResponseEntity<List<Penguin>> getPenguin() {
		return ResponseEntity.ok(this.service.getPenguin());
	}

	@GetMapping("/getPenguin/{id}")
	public Penguin getPenguinById(@PathVariable int id) {
		return this.service.getPenguinById(id);
	}

	@DeleteMapping("/removePenguin/{id}")
	public Penguin removePenguin(@PathVariable int id) {
		return this.service.removePenguin(id);
	}

}
