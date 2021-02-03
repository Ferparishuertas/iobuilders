package local.poc.blockchain.customers.management.registration.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import local.poc.blockchain.customers.management.registration.interceptors.LoggerInterceptor;

@Configuration
@EnableWebMvc
public class AppWebConfiguration implements WebMvcConfigurer {
	
	@Autowired
	private LoggerInterceptor loggerInterceptor;

	public AppWebConfiguration() {
		super();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(loggerInterceptor);
	}

}