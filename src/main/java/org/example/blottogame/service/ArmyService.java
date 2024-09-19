package org.example.blottogame.service;

import org.example.blottogame.model.Army;

public interface ArmyService {
	String saveArmy(Army army);
	String getArmy(String generalName);
	void deleteAllArmies();
}
