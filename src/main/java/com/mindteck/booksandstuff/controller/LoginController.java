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

//		System.out.println(user.getEmail());
//		System.out.println(user.getPassword());

		if (result.hasErrors()) {
//			model.addAttribute("user", new User());
//			model.addAttribute("users", userService.getUsers());
			return "/loginForm";
		}

		logger.info(user.getEmail());
		logger.debug(user.getPassword());
		if (userService.validateUsers(user.getEmail(), user.getPassword())) {
			session.setAttribute("userEmail", user.getEmail());

			User usr = userService.getUserByEmail(user.getEmail());
			//Cart sessionCart = cartService.createCart();


			session.setAttribute("userRoleId", usr.getRole().getId());
			session.setAttribute("userId", usr.getId().toString());
			session.setAttribute("uid", usr.getRole().getId());
			session.setAttribute("ssid", session.getId());

			Cart uCart = new Cart();
			uCart.setId((String) session.getAttribute("ssid"));


			Item i = itemService.getProductById(1L);
			CartItem ci = new CartItem();
			ci.setItem(i);
			ci.setQuantity(ci.getQuantity() + 1);
			ci.setTotalPrice(i.getPrice() * ci.getQuantity());




			uCart.getCartItems().add(ci);
			session.setAttribute("sessionCart", uCart);

			//session.setAttribute("sessionCart" sessionCart.getId());



			if (usr.getId() == 1) {
				return "admin/adminMenu";
			}

			/*model.addAttribute("user", new User());

			model.addAttribute("users", userService.getUsers());
			model.addAttribute("roles", roleService.getRoles());*/
			return "registeredUser/home";
		}



		//return "userForm";

		return "redirect:/loginForm";
	}
}



