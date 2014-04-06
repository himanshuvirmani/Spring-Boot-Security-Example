package org.himanshu.model.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.himanshu.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsDAOImpl{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addUser(UserDetails userDetails) {
		getCurrentSession().save(userDetails);
		return;
	}

}
