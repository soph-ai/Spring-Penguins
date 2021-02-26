package com.qa.penguins.service.penguin;

import java.util.List;

import com.qa.penguins.domain.Penguin;

public interface PenguinService {

	Penguin createPenguin(Penguin penguin);

	List<Penguin> getPenguin();

	Penguin getPenguinById(int id);

	Penguin removePenguin(int id);
}
