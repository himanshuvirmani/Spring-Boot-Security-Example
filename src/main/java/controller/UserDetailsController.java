package controller;

import model.UserDetails;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserDetailsController {
	
	private static final Logger logger = Logger.getLogger(UserDetailsController.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	@RequestMapping("/addUser")
	public @ResponseBody
	UserDetails addUser(
			@RequestParam(value = "uuid", required = true) String uuid,
			@RequestParam(value = "email", required = true) String email) {

		UserDetails userDetails = new UserDetails(uuid, email);

		logger.debug("XXX User id and email  " + uuid + " " + email);
		Session session = openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();

		return userDetails;
	}
}