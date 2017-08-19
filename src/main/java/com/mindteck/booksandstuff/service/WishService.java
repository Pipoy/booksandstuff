package com.mindteck.booksandstuff.service;

import com.mindteck.booksandstuff.dto.WishDTO;
import com.mindteck.booksandstuff.enitities.user.Wish;

import java.util.List;

/**
 * Created by Philip Lozada on 8/16/2017.
 */


public interface WishService {
	void addWish(WishDTO wishDTO);

//	void update(WishDTO wishDTO);

	List<WishDTO> getWishes(Long userID);
}
