package com.qa.penguins.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.penguins.domain.Penguin;
import com.qa.penguins.repos.PenguinRepo;
import com.qa.penguins.service.penguin.PenguinServiceDB;

@SpringBootTest
@ActiveProfiles("test")
public class PenguinServiceDBUnitTest {

	@Autowired
	private PenguinServiceDB service;

	@MockBean
	private PenguinRepo repo;

	@Test
	void testCreate() {
		// GIVEN
		Penguin newPenguin = new Penguin("Oswald", 4, 0, 64);
		Penguin savedPenguin = new Penguin(1L, "Oswald", 4, 0, 64);

		// WHEN
		Mockito.when(this.repo.save(newPenguin)).thenReturn(savedPenguin);

		// THEN
		assertThat(this.service.createPenguin(newPenguin)).isEqualTo(savedPenguin);

		Mockito.verify(this.repo, Mockito.times(1)).save(newPenguin);
	}

	@Test
	void testUpdate() {
		// GIVEN
		// ID
		Long id = 1L;
		// NEW PENGUIN DATA
		Penguin newPenguin = new Penguin("Pingu", 4, 0, 64);
		// OPTIONAL PENGUIN (basically existing penguin in a fancy wrapper)
		Optional<Penguin> optionalPenguin = Optional.of(new Penguin(id, null, 0, 0, 0));
		// UPDATED PENGUIN
		Penguin updatedPenguin = new Penguin(id, newPenguin.getName(), newPenguin.getAge(),
				newPenguin.getNoOfChildren(), newPenguin.getTuxedoSize());

		// WHEN
		Mockito.when(this.repo.findById(id)).thenReturn(optionalPenguin);
		// MAKE SURE THE MOCK INPUT HAS AN equals() METHOD
		Mockito.when(this.repo.save(updatedPenguin)).thenReturn(updatedPenguin);

		// THEN
		assertThat(this.service.updatePenguin(id, newPenguin)).isEqualTo(updatedPenguin);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(updatedPenguin);
	}
}
