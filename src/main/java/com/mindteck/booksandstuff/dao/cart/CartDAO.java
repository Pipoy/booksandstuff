package com.mindteck.booksandstuff.dao.cart;

import com.mindteck.booksandstuff.enitities.Cart;

/**
 * Created by Philip Lozada on 8/18/2017.
 */
public interface CartDAO {
	Cart createCart(Cart cart);

	Cart getCart(String cartId);

	void update(Long cartId);

	void delete(Long cartId);

}
