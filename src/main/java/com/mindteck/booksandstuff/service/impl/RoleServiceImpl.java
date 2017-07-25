package com.mindteck.booksandstuff.service.impl;

import com.mindteck.booksandstuff.dao.RoleDAO;
import com.mindteck.booksandstuff.enitities.user.Role;
import com.mindteck.booksandstuff.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Philip Lozada on 7/24/2017.
 */

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDao;

	@Override
	public Map<String, String> getRoles() {
		List<Role> roles = roleDao.getRoles();
		Map<String, String> roleMap = new HashMap<String,String>();
		for(Role role:roles){
			roleMap.put(Integer.toString(role.getId()), role.getName());
			System.out.println(role.getName()+" / "+role.getId());
		};
		return roleMap;
	}
}
