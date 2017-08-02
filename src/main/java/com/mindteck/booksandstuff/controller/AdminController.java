package com.mindteck.booksandstuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Philip Lozada on 8/1/2017.
 */

@Controller
public class AdminController {

	@GetMapping("/adminMenu")
	private String adminMenu(){
		return "adminMenu";
	}
}
