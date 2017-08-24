package com.mindteck.booksandstuff.service.impl;

import com.mindteck.booksandstuff.dao.RoleDAO;
import com.mindteck.booksandstuff.dao.UserDAO;
import com.mindteck.booksandstuff.dto.UserDTO;
import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.enitities.Order;
import com.mindteck.booksandstuff.enitities.user.Role;
import com.mindteck.booksandstuff.enitities.user.User;
import com.mindteck.booksandstuff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Philip Lozada on 7/24/2017.
 */

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDao;

	@Autowired
	private RoleDAO roleDao;


	@Transactional
	@Override
	public void add(UserDTO userDTO) {

		User user = new User();

		user.setId(userDTO.getId());
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		user.setRole(roleDao.getRole(Long.parseLong(userDTO.getRole())));
		user.setOrderHistory(userDTO.getOrderHistory());
		user.setOrders(userDTO.getOrdersList());
		userDao.add(user);
	}

	@Transactional(readOnly = true)
	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Transactional(readOnly = true)
	@Override
	public boolean validateUsers(String email, String password) {
		return userDao.validateUser(email, password);
	}

	@Transactional
	@Override
	public UserDTO getUser(String id) {
		User user = userDao.getUser(Long.parseLong(id));
		UserDTO userDto = new UserDTO();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setRole(Long.toString(user.getRole().getId()));
		userDto.setPassword(user.getPassword());

		List<Item> i = user.getOrderHistory();
		userDto.setOrderHistory(i);

		List<Order> o = user.getOrders();
		userDto.setOrdersList(o);


		return userDto;
	}



	@Transactional
	@Override
	public Role getRole(String email, String password) {
		return userDao.getRole(email, password);
	}

	@Transactional(readOnly = true)
	@Override
	public Role getRole(String id) {
		return userDao.getRole(id);
	}

	@Transactional
	@Override
	public User getUserByEmail(String email) {
		User user = userDao.getUserByEmail(email);
		return user;
	}

}
