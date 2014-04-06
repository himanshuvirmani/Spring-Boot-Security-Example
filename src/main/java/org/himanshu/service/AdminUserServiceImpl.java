package org.himanshu.service;

import org.himanshu.model.AdminUser;
import org.himanshu.model.implementation.AdminUserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminUserServiceImpl{
	
	@Autowired
	private AdminUserDAOImpl userDAO;

	public AdminUser getUser(String login) {
		return userDAO.getUser(login);
	}

}
