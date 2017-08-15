package com.mindteck.booksandstuff.controller;

import com.mindteck.booksandstuff.dto.UserDTO;
import com.mindteck.booksandstuff.enitities.user.User;
import com.mindteck.booksandstuff.service.RoleService;
import com.mindteck.booksandstuff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by Philip Lozada on 7/24/2017.
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;



	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") @Valid UserDTO user, BindingResult result, Model model) {

		if (result.hasErrors()) {

			model.addAttribute("users", userService.getUsers());
			model.addAttribute("roles", roleService.getRoles());
			return "/userForm";
		}

		System.out.println(user.getId()+" / "+user.getEmail()+" / "+user.getPassword());

		userService.add(user);

		return "userForm";
	}

	@GetMapping("/getUser")
	public String User(@RequestParam("id") String id, Model model) {

		System.out.println(id);


		model.addAttribute("user", userService.getUser(id));
		model.addAttribute("users", userService.getUsers());
		model.addAttribute("roles", roleService.getRoles());

		return "userForm";
	}

	@GetMapping("/addUser")
	public String User(  Model model) {

		model.addAttribute("user", new User());
		model.addAttribute("users", userService.getUsers());
		model.addAttribute("roles", roleService.getRoles());

		return "userForm";
	}
}
