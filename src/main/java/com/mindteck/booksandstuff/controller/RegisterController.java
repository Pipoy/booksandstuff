package com.mindteck.booksandstuff.controller;

import com.mindteck.booksandstuff.dto.UserDTO;
import com.mindteck.booksandstuff.enitities.user.User;
import com.mindteck.booksandstuff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Created by Philip Lozada on 8/14/2017.
 */

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;



	@GetMapping("/registerForm")
	public String register(Model model) {
		model.addAttribute("user", new User());

		return "anonymousUser/registerForm";
	}

	@PostMapping("/validateRegistration")
	public String validateRegistration(@ModelAttribute("user") @Valid UserDTO user, BindingResult result, Model model) {
		System.out.println(user.getId()+" / "+user.getEmail()+" / "+user.getPassword());
		if (result.hasErrors()) {

			model.addAttribute("user", new User());

			return "anonymousUser/registerForm";
		}

		 userService.add(user);

		return "anonymousUser/home";
	}

}
