package com.mindteck.booksandstuff.service.impl;

import com.mindteck.booksandstuff.dao.RoleDAO;
import com.mindteck.booksandstuff.dao.UserDAO;
import com.mindteck.booksandstuff.dto.UserDTO;
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
		System.out.println("Inside add userdto");
		User user = new User();
		if(userDTO.getId()!= null)
			user.setId(userDTO.getId());

		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		user.setRole(roleDao.getRole(Long.parseLong(userDTO.getRole())));


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

	@Transactional(readOnly = true)
	@Override
	public UserDTO getUser(String id) {
		User user = userDao.getUser(Long.parseLong(id));
		UserDTO userDto = new UserDTO();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setRole(Integer.toString(user.getRole().getId()));
		userDto.setPassword(user.getPassword());
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
}
