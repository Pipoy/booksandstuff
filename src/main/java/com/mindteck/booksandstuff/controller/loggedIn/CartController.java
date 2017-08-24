package com.mindteck.booksandstuff.controller.loggedIn;

import com.mindteck.booksandstuff.dto.CreditCardDTO;
import com.mindteck.booksandstuff.dto.OrderDTO;
import com.mindteck.booksandstuff.dto.OrderFormDTO;
import com.mindteck.booksandstuff.dto.UserDTO;
import com.mindteck.booksandstuff.enitities.Cart;
import com.mindteck.booksandstuff.enitities.CartItem;
import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.enitities.Order;
import com.mindteck.booksandstuff.service.ItemService;
import com.mindteck.booksandstuff.service.OrderService;
import com.mindteck.booksandstuff.service.UserService;
import com.mindteck.booksandstuff.service.cart.CartService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philip Lozada on 8/18/2017.
 */

@Controller
public class CartController {
	@Autowired
	SessionFactory sessionFactory;



	@Autowired
	private CartService cartService;

	@Autowired
	private UserService userService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private OrderService orderService;



	@GetMapping("/auth/cart")
	public String viewCart(Model model, HttpSession session) {
		Cart cart = (Cart) session.getAttribute("sessionCart");
		CartItem ci = new CartItem();


		model.addAttribute("cartItem", ci);
		model.addAttribute("cart", cart);

		model.addAttribute("cartItemList", cart.getCartItems());

		if (cart.getCartItems().isEmpty()) {
			return "registeredUser/emptyCart";
		}

		cart.updateGrandTotal();

		return "registeredUser/cart";

	}

	@GetMapping("auth/cart/{productId}")
	public String addItem(@PathVariable String productId, Model model, HttpSession session) {
		Item item = itemService.getProductById(Long.parseLong(productId));
		CartItem ci = new CartItem();
		ci.setId(item.getId());
		ci.setItem(item);
		ci.setQuantity(ci.getQuantity() + 1);
		ci.setTotalPrice(item.getPrice());

		ci.updateTotalPrice();

		Cart cart = (Cart) session.getAttribute("sessionCart");

		cart.getCartItems().add(ci);
		cart.updateGrandTotal();
		return "redirect:/auth/cart";

	}

	@GetMapping("auth/cart/removeItem/{productId}")
	public String removeItem(@PathVariable Long productId, HttpSession session) {
		Item item = itemService.getProductById(productId);
		CartItem ci = new CartItem();
		ci.setItem(item);
		ci.setQuantity(ci.getQuantity() + 1);
		ci.updateTotalPrice();

		Cart cart = (Cart) session.getAttribute("sessionCart");
		System.out.println(cart.getCartItems().size());

		int ii =0;
		for(int i=0; i<cart.getCartItems().size(); i++) {
			if (cart.getCartItems().get(i).getId() == item.getId()) {
				ii = i;
			}
		}
		cart.getCartItems().remove(ii);

		if (cart.getCartItems().isEmpty()) {
			return "registeredUser/emptyCart";
		}

		return "redirect:/auth/cart";



	}

	@GetMapping("auth/cart/emptyCart")
	public String emptyCart(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("sessionCart");
		cart.getCartItems().clear();
		session.setAttribute("sessionCart", cart);
		return "registeredUser/cart";
	}


	@GetMapping("auth/cart/orderForm")
	public String submitCart(Model model, HttpSession session) {
		Cart cart = (Cart) session.getAttribute("sessionCart");
		OrderFormDTO orderFormDTO = new OrderFormDTO();

		model.addAttribute("orderForm", orderFormDTO);
		model.addAttribute("cart", cart);

		return "registeredUser/orderForm";
	}


	@GetMapping("auth/cart/creditCardForm")
	public String creditCardForm(Model model) {
		CreditCardDTO creditCardDTO = new CreditCardDTO();

		model.addAttribute("creditCardForm", creditCardDTO);

		return "registeredUser/creditCardForm";

	}


	@GetMapping("auth/cart/orderSummary")
	public String submitOrder(HttpSession session, Model model) {
		Cart cart = (Cart) session.getAttribute("sessionCart");

		model.addAttribute("cart", cart);
		model.addAttribute("cartItemList", cart.getCartItems());


		String roleId =  (String) session.getAttribute("userId");
		String email =  (String) session.getAttribute("userEmail");

		Long uid = (Long) session.getAttribute("userId2");

		UserDTO currentUser = userService.getUser(roleId);


		List<Item> orderHistory = new ArrayList<>();
		List<Order> u = new ArrayList<>();


		Order order = new Order();
		order.setUsers(userService.getUserByEmail(email));




		List<Item> c = new ArrayList<>();

		for (CartItem item : cart.getCartItems()) {
//			order.getOrderItems().add(itemService.getProductById(item.getItem().getId()));
			c.add(itemService.getProductById(item.getItem().getId()));





//			orderHistory.add(itemService.getProductById(item.getItem().getId()));
		}
//
//		currentUser.setOrdersList(u);

		order.setItem(c);
		order.setTotalPrice(cart.getGrandTotal());
		orderService.addOrder(order);


		List<Order> i = userService.getUser(uid.toString()).getOrdersList();


//		List<Item> i = userService.getUser(uid.toString()).getOrderHistory();
//		orderHistory.addAll(i);
//		currentUser.setOrderHistory(orderHistory);
//
//		userService.add( currentUser );

		return "registeredUser/orderSummary";
	}

	@GetMapping("auth/cart/finish")
	public String finish(HttpSession session, Model model) {
		Cart cart = (Cart) session.getAttribute("sessionCart");
		cart.getCartItems().clear();


		return "registeredUser/home";

	}
}
