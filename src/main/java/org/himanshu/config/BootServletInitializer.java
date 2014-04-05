/**
 * 
 */
package org.himanshu.config;

/**
 * @author himanshu
 *
 */
import org.apache.log4j.Logger;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

public class BootServletInitializer extends SpringBootServletInitializer {

	private static final Logger logger = Logger
			.getLogger(BootServletInitializer.class);

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		logger.info("XXX Application booted ");
		return application.sources(Application.class, SecurityConfig.class,
				WebAppConfig.class);
	}
	
}