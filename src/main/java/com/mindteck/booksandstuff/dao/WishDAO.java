package com.mindteck.booksandstuff.dao;

import com.mindteck.booksandstuff.enitities.user.Wish;

import java.util.List;

/**
 * Created by Philip Lozada on 8/15/2017.
 */
public interface WishDAO {
	void addWish(Wish wish);

	void update(Wish wish);

	List<Wish> getUserWishList(Long userId);

}
