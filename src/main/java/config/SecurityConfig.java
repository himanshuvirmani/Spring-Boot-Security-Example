package config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import service.CustomUserDetailsService;

@Configuration
@ComponentScan({"service","model"})
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger logger = Logger.getLogger(SecurityConfig.class);

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		logger.info("XXX configure HTTP User detail service");
		
		http.userDetailsService(customUserDetailsService)
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/sec/moderation.html").hasRole("MODERATOR")
			.antMatchers("/admin/**").hasRole("ADMIN")
			.and()
			.formLogin()
			.permitAll()
			.and()
			.logout()
			.logoutSuccessUrl("/index.html");
	}

}
