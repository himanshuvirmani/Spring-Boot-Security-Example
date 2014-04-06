package org.himanshu.model.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.himanshu.model.AdminRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRoleDAOImpl{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public AdminRole getRole(int id) {
		AdminRole role = (AdminRole) getCurrentSession().load(AdminRole.class, id);
		return role;
	}

}
