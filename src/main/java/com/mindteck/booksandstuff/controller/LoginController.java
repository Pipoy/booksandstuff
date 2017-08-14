package com.mindteck.booksandstuff.controller;

import com.mindteck.booksandstuff.enitities.user.User;
import com.mindteck.booksandstuff.service.RoleService;
import com.mindteck.booksandstuff.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


/**
 * Created by Philip Lozada on 7/24/2017.
 */

@Controller
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@PostMapping("/login")
	public String validateUser(@ModelAttribute("user") @Valid User user,
	                           BindingResult result,
	                           Model model,
	                           HttpSession session) {

//		System.out.println(user.getEmail());
//		System.out.println(user.getPassword());

		if (result.hasErrors()) {
			return "redirect:/";
		}

		logger.info(user.getEmail());
		logger.debug(user.getPassword());
		if (userService.validateUsers(user.getEmail(), user.getPassword())) {
			session.setAttribute("userEmail", user.getEmail());

			User usr = userService.getUserByEmail(user.getEmail());

			session.setAttribute("userRoleId", usr.getRole().getId());
			if (usr.getId() == 1) {
				return "admin/adminMenu";
			}

			/*model.addAttribute("user", new User());

			model.addAttribute("users", userService.getUsers());
			model.addAttribute("roles", roleService.getRoles());*/
			return "registeredUser/home";
		}


		//return "userForm";

		return "redirect:/";
	}
}



