package org.example.blottogame.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Army {
	private List<Integer> soldiers = new ArrayList<>();
}
