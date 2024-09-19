package org.example.blottogame.controller;

import lombok.RequiredArgsConstructor;
import org.example.blottogame.repository.ArmyRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DatabaseController {

	private final ArmyRepository repository;

	@DeleteMapping("/clear-database")
	public void deleteAll() {
		repository.deleteAll();;
	}
}
