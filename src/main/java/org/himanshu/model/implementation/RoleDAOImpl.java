package org.himanshu.model.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.himanshu.model.AdminRole;

@Repository
public class RoleDAOImpl{
	
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
