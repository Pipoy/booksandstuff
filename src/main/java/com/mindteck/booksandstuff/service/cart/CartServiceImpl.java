package com.mindteck.booksandstuff.service.cart;

import com.mindteck.booksandstuff.dao.cart.CartDAO;
import com.mindteck.booksandstuff.dto.CartDTO;
import com.mindteck.booksandstuff.enitities.Cart;
import com.mindteck.booksandstuff.enitities.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Philip Lozada on 8/18/2017.
 */

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDAO;

	@Transactional
	@Override
	public CartDTO getCart(String id) {
		Cart cart = cartDAO.getCart(id);



		CartDTO cartDTO = new CartDTO();

		cartDTO.setId(cart.getId());
		cartDTO.setGrandTotal(cart.getGrandTotal());

		for (CartItem c : cart.getCartItems()) {
			cartDTO.getCartItemList().add(c);
		}

		return cartDTO;
	}
}
