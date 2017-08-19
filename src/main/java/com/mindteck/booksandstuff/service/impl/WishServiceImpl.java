package com.mindteck.booksandstuff.service.impl;

import com.mindteck.booksandstuff.dao.UserDAO;
import com.mindteck.booksandstuff.dao.WishDAO;
import com.mindteck.booksandstuff.dao.item.ItemDAO;
import com.mindteck.booksandstuff.dto.WishDTO;
import com.mindteck.booksandstuff.enitities.user.Wish;
import com.mindteck.booksandstuff.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philip Lozada on 8/16/2017.
 */
@Service
public class WishServiceImpl implements WishService{


	@Autowired
	private WishDAO wishDAO;


	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ItemDAO itemDAO;



	@Transactional
	@Override
	public void addWish(WishDTO wishDTO) {
		Wish wish = new Wish();
		wish.setId(wishDTO.getId());
		wish.setItem(itemDAO.getItem(Long.parseLong(wishDTO.getItemId())));
		wish.setUser(userDAO.getUser(Long.parseLong(wishDTO.getUserId())));
		wishDAO.addWish(wish);

	}
//	@Transactional
//	@Override
//	public void update(WishDTO wishDTO) {
//
//
//	}
	@Transactional
	@Override
	public List<WishDTO> getWishes(Long userID) {
		List<Wish> wishes = wishDAO.getUserWishList(userID);


		List<WishDTO> wishesDTO = new ArrayList<>();
		for (Wish w : wishes) {
			WishDTO wdto = new WishDTO();
			wdto.setItemId(Long.toString(w.getItem().getId()));
			wdto.setId(w.getId());
			wdto.setUserId(Long.toString(w.getUser().getId()));
			wishesDTO.add(wdto);
//
// uw.setUser(userDAO.getUser(userID));


		}


		return wishesDTO;
		//return wishDAO.getUserWishList(userID);
	}
}
