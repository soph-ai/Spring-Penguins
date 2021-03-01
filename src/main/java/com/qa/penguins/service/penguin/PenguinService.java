package com.qa.penguins.service.penguin;

import java.util.List;

import com.qa.penguins.domain.Penguin;

public interface PenguinService {

	Penguin createPenguin(Penguin penguin);

	List<Penguin> getPenguin();

	Penguin getPenguinById(Long id);

	boolean removePenguin(Long id);

	Penguin updatePenguin(Long id, Penguin newPenguin);

	Penguin getPenguinByName(String name);
}
