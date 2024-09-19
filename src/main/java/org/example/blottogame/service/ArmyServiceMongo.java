package org.example.blottogame.service;

import lombok.RequiredArgsConstructor;
import org.example.blottogame.mapper.ArmyMapper;
import org.example.blottogame.model.Army;
import org.example.blottogame.model.ArmyDao;
import org.example.blottogame.repository.ArmyRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArmyServiceMongo implements ArmyService {

	private final ArmyRepository repository;

	@Override
	public String saveArmy(Army army) {
		var optional = repository.getByGeneralName(army.getGeneralName());
		if (optional.isPresent()) {
			return "You already have sent your army, general";
		}
		var dao = ArmyMapper.INSTANCE.toDao(army);
		repository.save(dao);
		return "Your army is added to battlefield";
	}

	@Override
	public String getArmy(String generalName) {
		var optional = repository.getByGeneralName(generalName);
		if (optional.isEmpty()) {
			return "You have no armies, " + generalName;
		}
		return optional.get().getSoldiers().toString();
	}

	@Override
	public void battle() {
		System.out.println("LET THE GREATEST BATTLE OF HISTORY START");
		System.out.println();
		var all = repository.findAll();
		for (int i = 0; i < all.size()-1; i++) {
			for (int k = i+1; k < all.size(); k++) {
				var army1Dao = all.get(i);
				var army2Dao = all.get(k);

				var army1 = ArmyMapper.INSTANCE.toModel(army1Dao);
				var army2 = ArmyMapper.INSTANCE.toModel(army2Dao);

				var fight = fight(army1, army2);

				System.out.println("Army1: " + army1.toString());
				System.out.println("Army2: " + army2.toString());
				System.out.println(fight);
				System.out.println();
			}

		}
	}

	public String fight(Army army1, Army army2) {
		int army1VictoryPoints = 0;
		int army2VictoryPoints = 0;

		for (int i = 0; i < army1.getSoldiers().size(); i++) {
			var i1 = army1.getSoldiers().get(i);
			var i2 = army2.getSoldiers().get(i);
			if (i1 > i2) {
				army1VictoryPoints++;
			} else if (i2 > i1) {
				army2VictoryPoints++;
			}
		}

		if (army1VictoryPoints>army2VictoryPoints) {
			return "army of general " + army1.getGeneralName() + " wins";
		} else if (army2VictoryPoints>army1VictoryPoints) {
			return "army of general " + army2.getGeneralName() + " wins";
		} else {
			return "it's a draw";
		}
	}

}
