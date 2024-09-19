package org.example.blottogame.mapper;

import org.example.blottogame.model.Army;
import org.example.blottogame.model.ArmyDao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArmyMapper {
	ArmyMapper INSTANCE = Mappers.getMapper(ArmyMapper.class);
	ArmyDao toDao(Army item);
	Army toModel(ArmyDao item);
}
