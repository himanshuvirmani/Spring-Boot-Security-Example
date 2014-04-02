package model.implementation;

import java.util.ArrayList;
import java.util.List;

import model.AdminUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl{
	
	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	public AdminUser getUser(String login) {
		List<AdminUser> userList = new ArrayList<AdminUser>();
		Query query = openSession().createQuery("from User u where u.login = :login");
		query.setParameter("login", login);
		userList = query.list();
		logger.info("XXX Login name : -" + login);
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;	
	}

}
