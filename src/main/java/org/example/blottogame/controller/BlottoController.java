package org.example.blottogame.controller;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class BlottoController {

	@SneakyThrows
	@PostMapping(value = "/blotto", consumes = "application/json")
	public String blotto(@RequestBody List<Integer> army) {
		System.out.println("Got request");

		if (army.size() != 9) {
			throw new Exception("army size should be 9. Your army size is " + army.size());
		}

		var soldiersCount = army.stream().reduce(0, Integer::sum);
		if (soldiersCount != 100) {
			throw new Exception("soldiers sum should be 100. Your soldiers sum is " + soldiersCount);
		}

		return "your army is added to battlefield";
	}
}
