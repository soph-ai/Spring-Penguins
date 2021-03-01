package com.qa.penguins.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.penguins.domain.Penguin;

@Repository
public interface PenguinRepo extends JpaRepository<Penguin, Long> {

}
