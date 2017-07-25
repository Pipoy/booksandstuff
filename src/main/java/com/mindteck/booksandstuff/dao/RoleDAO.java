package com.mindteck.booksandstuff.dao;

import com.mindteck.booksandstuff.enitities.user.Role;

import java.util.List;

/**
 * Created by Philip Lozada on 7/24/2017.
 */
public interface RoleDAO {
	List<Role> getRoles();
	Role getRole(Long id);
}
