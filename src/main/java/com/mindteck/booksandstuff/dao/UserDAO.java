package com.mindteck.booksandstuff.dao;

import com.mindteck.booksandstuff.enitities.user.Role;
import com.mindteck.booksandstuff.enitities.user.User;

import java.util.List;

/**
 * Created by Philip Lozada on 7/24/2017.
 */

public interface UserDAO {

	void add(User user);
	List<User> getUsers();
	boolean validateUser(String email, String password);
	User getUser(Long id);


	Role getRole(String email, String password);
	Role getRole(String id);
}
