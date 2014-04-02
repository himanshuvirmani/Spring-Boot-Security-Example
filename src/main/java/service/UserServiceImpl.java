package service;

import model.AdminUser;
import model.implementation.UserDAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl{
	
	@Autowired
	private UserDAOImpl userDAO;

	public AdminUser getUser(String login) {
		return userDAO.getUser(login);
	}

}
