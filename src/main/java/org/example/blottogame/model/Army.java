package org.example.blottogame.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Army {
	private String generalName;
	private List<Integer> soldiers;
}
