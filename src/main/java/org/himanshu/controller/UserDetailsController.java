package org.himanshu.controller;

import org.apache.log4j.Logger;
import org.himanshu.model.UserDetails;
import org.himanshu.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserDetailsController {
	
	private static final Logger logger = Logger.getLogger(UserDetailsController.class);
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@RequestMapping("/addUser")
	public @ResponseBody
	UserDetails addUser(
			@RequestParam(value = "uuid", required = true) String uuid,
			@RequestParam(value = "email", required = true) String email) {

		UserDetails userDetails = new UserDetails(uuid, email);

		logger.info("XXX User id and email  " + uuid + " " + email);
		userDetailsService.addUser(userDetails);
		return userDetails;
	}
}