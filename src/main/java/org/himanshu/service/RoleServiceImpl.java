package org.himanshu.service;

import org.himanshu.model.AdminRole;
import org.himanshu.model.implementation.RoleDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl {
	
	@Autowired
	private RoleDAOImpl roleDAO;

	public AdminRole getRole(int id) {
		return roleDAO.getRole(id);
	}

}
