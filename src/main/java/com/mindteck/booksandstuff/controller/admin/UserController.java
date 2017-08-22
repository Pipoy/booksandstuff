package com.mindteck.booksandstuff.controller.admin;

import com.mindteck.booksandstuff.dto.UserDTO;
import com.mindteck.booksandstuff.enitities.user.User;
import com.mindteck.booksandstuff.service.RoleService;
import com.mindteck.booksandstuff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by Philip Lozada on 7/24/2017.
 */
@Controller
@RequestMapping("/admin/userManager")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;



	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") @Valid UserDTO user,
	                       BindingResult result, Model model,
	                       HttpSession session) {


		Long roleId = (Long) session.getAttribute("userRoleId");
		if (roleId==1) {
			if (result.hasErrors()) {

				model.addAttribute("users", userService.getUsers());
				model.addAttribute("roles", roleService.getRoles());
				return "/userForm";
			}

			System.out.println(user.getId()+" / "+user.getEmail()+" / "+user.getPassword());

			userService.add(user);

			return "redirect:/admin/userManager/addUser";

		}else {
			return "redirect:/";
		}
	}

	@GetMapping("/getUser")
	public String User(@RequestParam("id") String id, Model model, HttpSession session) {

		System.out.println(id);

		Long roleId = (Long) session.getAttribute("userRoleId");
		if (roleId==1) {
			model.addAttribute("user", userService.getUser(id));
			model.addAttribute("users", userService.getUsers());
			model.addAttribute("roles", roleService.getRoles());
			return "userForm";
		}else {
			return "redirect:/";
		}



	}

	@GetMapping("/addUser")
	public String User(Model model, HttpSession session) {

		Long roleId = (Long) session.getAttribute("userRoleId");
		if (roleId==1) {
			model.addAttribute("user", new User());
			model.addAttribute("users", userService.getUsers());
			model.addAttribute("roles", roleService.getRoles());

			return "userForm";
		}else {
			return "redirect:/";
		}

	}
}
