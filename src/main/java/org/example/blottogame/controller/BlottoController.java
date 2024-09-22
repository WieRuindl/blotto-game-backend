package org.example.blottogame.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.example.blottogame.model.Army;
import org.example.blottogame.service.ArmyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class BlottoController {

	private final ArmyService armyService;

	@SneakyThrows
	@PostMapping(value = "/blotto", consumes = "application/json")
	public ResponseEntity<String> blotto(@RequestBody Army army) {
		System.out.println(army.toString());
		log.info(army.toString());
		if (army.getSoldiers().size() != 9) {
			throw new Exception("army size should be 9. Your army size is " + army.getSoldiers().size());
		}

		var soldiersCount = army.getSoldiers().stream().reduce(0, Integer::sum);
		if (soldiersCount != 100) {
			throw new Exception("soldiers sum should be 100. Your soldiers sum is " + soldiersCount);
		}

		var response = armyService.saveArmy(army);
		System.out.println(response);
		log.info(response);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping(value = "/get-army/{generalName}")
	public ResponseEntity<String> getArmy(@PathVariable String generalName) {
		var response = armyService.getArmy(generalName);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping(value = "/battle/")
	public ResponseEntity<String> battle() {
		armyService.battle();
		return ResponseEntity.ok("battle ended");
	}


}
