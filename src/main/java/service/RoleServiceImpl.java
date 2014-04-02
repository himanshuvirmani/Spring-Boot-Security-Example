package service;

import model.AdminRole;
import model.implementation.RoleDAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class RoleServiceImpl {
	
	@Autowired
	private RoleDAOImpl roleDAO;

	public AdminRole getRole(int id) {
		return roleDAO.getRole(id);
	}

}
