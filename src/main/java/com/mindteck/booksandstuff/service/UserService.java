package com.mindteck.booksandstuff.service;

import com.mindteck.booksandstuff.dto.UserDTO;
import com.mindteck.booksandstuff.enitities.user.Role;
import com.mindteck.booksandstuff.enitities.user.User;

import java.util.List;

/**
 * Created by Philip Lozada on 7/24/2017.
 */
public interface UserService {

	void add(UserDTO user);
	List<User> getUsers();
	boolean validateUsers(String email, String password);
	UserDTO getUser(String id);

	User getUserByEmail(String email);


	Role getRole(String email, String password);
	Role getRole(String id);
}
