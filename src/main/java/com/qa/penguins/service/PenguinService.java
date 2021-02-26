package com.qa.penguins.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.penguins.domain.Penguin;

@Service
public class PenguinService {

	private List<Penguin> penguins; // <- dependency

	public PenguinService(List<Penguin> penguins) {
		super();
		this.penguins = penguins;
	}

	public Penguin createPenguin(Penguin penguin) {
		this.penguins.add(penguin);
		Penguin added = this.penguins.get(this.penguins.size() - 1);
		return added;
	}

	public List<Penguin> getPenguin() {
		return this.penguins;
	}

	public Penguin getPenguinById(int id) {
		return this.penguins.get(id);
	}

	public Penguin removePenguin(int id) {
		return this.penguins.remove(id);
	}

}
