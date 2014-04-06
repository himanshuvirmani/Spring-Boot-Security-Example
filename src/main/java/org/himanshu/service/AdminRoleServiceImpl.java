package org.himanshu.service;

import org.himanshu.model.AdminRole;
import org.himanshu.model.implementation.AdminRoleDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminRoleServiceImpl {
	
	@Autowired
	private AdminRoleDAOImpl roleDAO;

	public AdminRole getRole(int id) {
		return roleDAO.getRole(id);
	}

}
