package com.mindteck.booksandstuff.service.cart;

import com.mindteck.booksandstuff.dto.CartDTO;
import com.mindteck.booksandstuff.enitities.Cart;

/**
 * Created by Philip Lozada on 8/18/2017.
 */
public interface CartService {
	CartDTO getCart(String id);
}
