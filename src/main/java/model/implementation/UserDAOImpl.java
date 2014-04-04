package model.implementation;

import java.util.ArrayList;
import java.util.List;

import model.AdminUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Repository
@Transactional
public class UserDAOImpl{
	
	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	public AdminUser getUser(String login) {
		List<AdminUser> userList = new ArrayList<AdminUser>();
		try {
		Query query = openSession().createQuery("FROM model.AdminUser u WHERE u.login = :login");		
		query.setParameter("login", login);
		logger.debug("XXX query : -" + query.getQueryString());
		userList = query.list();
		} catch(HibernateException e){
			logger.error("XXX Hibernate exception occured");
			e.printStackTrace();
		}				
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;	
	}

}
