package com.mindteck.booksandstuff.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Philip Lozada on 8/1/2017.
 */

@Controller
public class AdminController {

	@GetMapping("/adminMenu")
	private String adminMenu(HttpSession session){
		Long roleId = (Long) session.getAttribute("userRoleId");
		if (roleId==1) {
			return "admin/adminMenu";
		}else {
			return "redirect:/";
		}


	}
}
