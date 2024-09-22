package org.example.blottogame.repository;

import org.example.blottogame.model.ArmyDao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ArmyMongoRepository extends MongoRepository<ArmyDao, String> {
	Optional<ArmyDao> getByGeneralName(String generalName);
}
