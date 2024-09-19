package org.example.blottogame.controller;

import lombok.RequiredArgsConstructor;
import org.example.blottogame.service.ArmyService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DatabaseController {

	private final ArmyService armyService;

	@DeleteMapping("/clear-database")
	public void deleteAll() {
		armyService.deleteAllArmies();
	}
}
