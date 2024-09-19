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

	public String getArmy(Army army) {
		var optional = repository.getByGeneralName(army.getGeneralName());
		if (optional.isPresent()) {
			return "You already have sent your army, general";
		}
		var dao = ArmyMapper.INSTANCE.toDao(army);
		repository.save(dao);
		return "Your army is added to battlefield";
	}

	@Override
	public void deleteAllArmies() {
		repository.deleteAll();;
	}
}
