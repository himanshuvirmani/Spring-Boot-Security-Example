package org.himanshu.service;

import org.himanshu.model.UserDetails;
import org.himanshu.model.implementation.UserDetailsDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl {
	
	@Autowired
	private UserDetailsDAOImpl userDetailsDAO;

	public void addUser(UserDetails userDetails) {
		userDetailsDAO.addUser(userDetails);
	}

}
