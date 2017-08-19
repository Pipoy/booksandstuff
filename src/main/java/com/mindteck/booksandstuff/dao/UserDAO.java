package com.mindteck.booksandstuff.dao;

import com.mindteck.booksandstuff.enitities.user.Role;
import com.mindteck.booksandstuff.enitities.user.User;
import com.mindteck.booksandstuff.enitities.user.Wish;

import java.util.List;

/**
 * Created by Philip Lozada on 7/24/2017.
 */

public interface UserDAO {

	void add(User user);
	List<User> getUsers();
	boolean validateUser(String email, String password);
	User getUser(Long id);

	User getUserByEmail(String email);


	Role getRole(String email, String password);
	Role getRole(String id);

//	List<Wish> getWishList(Long userId);

}
