package com.mindteck.booksandstuff.controller;

import com.mindteck.booksandstuff.dto.UserDTO;
import com.mindteck.booksandstuff.enitities.Cart;
import com.mindteck.booksandstuff.enitities.CartItem;
import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.enitities.user.User;
import com.mindteck.booksandstuff.service.ItemService;
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
import java.util.Locale;


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

	@Autowired
	private ItemService itemService;

	@GetMapping("/loginForm")
	public String userForm(Model model) {
//
		model.addAttribute("user", new User());
//		model.addAttribute("users", userService.getUsers());

		return "loginForm";
		//return "userForm";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("user") @Valid UserDTO user,
	                           BindingResult result,
	                           Model model,
	                           HttpSession session) {

		if (result.hasErrors()) {
			return "/loginForm";
		}

		logger.info(user.getEmail());
		logger.debug(user.getPassword());
		if (userService.validateUsers(user.getEmail(), user.getPassword())) {
			session.setAttribute("userEmail", user.getEmail());

			User usr = userService.getUserByEmail(user.getEmail());


			session.setAttribute("userRoleId", usr.getRole().getId());
			session.setAttribute("userId", usr.getId().toString());
			session.setAttribute("userId2", usr.getId());
			session.setAttribute("uid", usr.getRole().getId());
			session.setAttribute("ssid", session.getId());
			session.setAttribute("orderHistory", usr.getOrderHistory());
			session.setAttribute("userEmail", usr.getEmail());

			Cart userCart = new Cart();
			userCart.setId((String) session.getAttribute("ssid"));

			session.setAttribute("sessionCart", userCart);
			session.setAttribute("grandTotal", userCart.getGrandTotal());

			if (usr.getRole().getId() == 1) {
				return "admin/adminMenu";
			}
			return "registeredUser/home";
		}



		//return "userForm";

		return "redirect:/loginForm";
	}
}



