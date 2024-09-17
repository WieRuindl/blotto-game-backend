package org.example.blottogame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String forwardToIndex() {
		return "forward:/flutter/index.html";
	}

}
