package org.example.blottogame.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Army {
	private String generalName;
	private List<Integer> soldiers;
}
