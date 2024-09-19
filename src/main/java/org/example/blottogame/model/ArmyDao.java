package org.example.blottogame.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "army")
public class ArmyDao {
	@Id
	private String id;
	private String generalName;
	private List<Integer> soldiers;
}
