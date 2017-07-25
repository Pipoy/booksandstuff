package com.mindteck.booksandstuff.controller;

import com.mindteck.booksandstuff.enitities.user.User;
import com.mindteck.booksandstuff.service.RoleService;
import com.mindteck.booksandstuff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Philip Lozada on 7/24/2017.
 */

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@PostMapping("/login")
	public String validateUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model, HttpSession session) {

		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		if (userService.validateUsers(user.getEmail(), user.getPassword())) {
			session.setAttribute("userEmail", user.getEmail());
			/*model.addAttribute("user", new User());

			model.addAttribute("users", userService.getUsers());
			model.addAttribute("roles", roleService.getRoles());*/
			return "Menu";
		}


		//return "userForm";

		return "redirect:/";
	}
}
