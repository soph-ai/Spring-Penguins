package com.qa.penguins.service.penguin;

import java.util.List;

import com.qa.penguins.domain.Penguin;

public class PenguinServiceList implements PenguinService {

	private List<Penguin> penguins;

	public PenguinServiceList(List<Penguin> penguins) {
		super();
		this.penguins = penguins;
	}

	@Override
	public Penguin createPenguin(Penguin penguin) {
		this.penguins.add(penguin);
		Penguin added = this.penguins.get(this.penguins.size() - 1);
		return added;
	}

	@Override
	public List<Penguin> getPenguin() {
		return this.penguins;
	}

	@Override
	public Penguin getPenguinById(Long id) {
		return this.penguins.get(id.intValue());
	}

	@Override
	public boolean removePenguin(Long id) {
		Penguin penguin = this.penguins.get(id.intValue());
		this.penguins.remove(id.intValue());
		return !this.penguins.contains(penguin);
	}

	@Override
	public Penguin updatePenguin(Long id, Penguin newPenguin) {
		this.removePenguin(id);
		this.penguins.add(id.intValue(), newPenguin);
		return this.penguins.get(id.intValue());
	}

	@Override
	public Penguin getPenguinByName(String name) {
		for (Penguin p : this.penguins) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

}
