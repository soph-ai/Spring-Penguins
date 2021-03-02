package com.qa.penguins.service.penguin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.penguins.domain.Penguin;
import com.qa.penguins.repos.PenguinRepo;

@Service
public class PenguinServiceDB implements PenguinService {

	private PenguinRepo repo;

	public PenguinServiceDB(PenguinRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Penguin createPenguin(Penguin penguin) {
		return this.repo.save(penguin);
	}

	@Override
	public List<Penguin> getPenguin() {
		return this.repo.findAll();
	}

	@Override
	public Penguin getPenguinById(Long id) {
		Optional<Penguin> optPenguin = this.repo.findById(id);
		return optPenguin.get();
//		Penguin penguin = this.repo.findById(id);
//		if (penguin != null) {
//			return penguin;
//		} else {
//			return null;
//		}
	}

	@Override
	public Penguin getPenguinByName(String name) {
		return this.repo.findByName(name);
	}

	@Override
	public boolean removePenguin(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	@Override
	public Penguin updatePenguin(Long id, Penguin newPenguin) {
		Penguin existing = this.getPenguinById(id);

		existing.setAge(newPenguin.getAge());
		existing.setName(newPenguin.getName());
		existing.setNoOfChildren(newPenguin.getNoOfChildren());
		existing.setTuxedoSize(newPenguin.getTuxedoSize());

		return this.repo.save(existing);
	}

}
