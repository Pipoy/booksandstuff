package com.mindteck.booksandstuff.controller.loggedIn;

import com.mindteck.booksandstuff.dto.CartDTO;
import com.mindteck.booksandstuff.enitities.Cart;
import com.mindteck.booksandstuff.enitities.CartItem;
import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.service.ItemService;
import com.mindteck.booksandstuff.service.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Philip Lozada on 8/18/2017.
 */

@Controller
public class CartController {


	@Autowired
	private CartService cartService;

	@Autowired
	private ItemService itemService;



	@GetMapping("/auth/cart")
	public String viewCart(Model model, HttpSession session) {
		Cart cart = (Cart) session.getAttribute("sessionCart");
		CartItem ci = new CartItem();


		model.addAttribute("cartItem", ci);
		model.addAttribute("cart", cart);

		model.addAttribute("cartItemList", cart.getCartItems());


		return "registeredUser/cart";

	}

	@GetMapping("auth/cart/{productId}")
	public String addItem(@PathVariable String productId, Model model, HttpSession session) {
		Item item = itemService.getProductById(Long.parseLong(productId));
		CartItem ci = new CartItem();
		ci.setItem(item);
		ci.setQuantity(ci.getQuantity() + 1);
		ci.updateTotalPrice();

		Cart cart = (Cart) session.getAttribute("sessionCart");
		cart.getCartItems().add(ci);

		//cart.removeCartItem();



		return "redirect:/auth/cart";

	}

	@GetMapping("auth/cart/removeItem/{productId}")
	public String removeItem(@PathVariable String productId, HttpSession session) {
		Item item = itemService.getProductById(Long.parseLong(productId));
//		CartItem ci = new CartItem();
//		ci.setItem(item);
//		ci.setQuantity(ci.getQuantity() + 1);
//		ci.updateTotalPrice();

		Cart cart = (Cart) session.getAttribute("sessionCart");

		for (CartItem ci : cart.getCartItems()) {
			if (ci.getItem().getId().equals(item.getId())) {
				cart.getCartItems().remove(ci);
			}
		}
		return "redirect:/auth/cart";

	}





//
//	@GetMapping("auth/cart/{productId}")
//	public String updateQuantity(@PathVariable String productId){
//		return "redirect:/auth/cart";
//
//	}

}
