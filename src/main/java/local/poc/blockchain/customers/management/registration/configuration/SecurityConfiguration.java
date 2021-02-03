package local.poc.blockchain.customers.management.registration.configuration;

import static local.poc.blockchain.customers.management.registration.util.Global.getTimestampNowTxt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import local.poc.blockchain.customers.management.registration.datobj.dto.ResponseEnvelope;
import local.poc.blockchain.customers.management.registration.filter.JWTAuthenticationFilter;
import local.poc.blockchain.customers.management.registration.filter.JWTAuthorizationFilter;
import local.poc.blockchain.customers.management.registration.filter.JWTParams;
import local.poc.blockchain.customers.management.registration.service.UserService;

@Profile(value = {"local"})
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWTParams jwtParams;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// // DO NOT ALLOW httpBasic() or the basic authentication will be allowed
		// // and it could overpass the Barer Authentication of JWT
		// http.httpBasic();
		
		// Disable CSRF
		http.csrf().disable();
		
		// Without session for REST API!!!
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		// Indicate which urls are accesible for anybody and which ones need authentication.
		http.authorizeRequests()
			.regexMatchers("/ureg/v1/[^/]+(/)?$",
						   "/ureg/v1/[^/]+/person(/)?$",
						   "/ureg/v1/[^/]+/person/new.*$",
						   "/ureg/v1/[^/]+/corporation.*$",
						   "/ureg/v1/[^/]+/check_login.*$").permitAll()
			.regexMatchers("/ureg/v1/[^/]+/person/list.*$").authenticated()
			// DO NOT USE ACCESS DENIED HANDLER...
		    // .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler());
			.and().exceptionHandling().authenticationEntryPoint(http403ForbiddenEntryPoint());
		
		// Add JWT filters
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtParams))
			.addFilterBefore(
					new JWTAuthorizationFilter(authenticationManager(), jwtParams, userService),
					BasicAuthenticationFilter.class);
	}
	
	@Bean
	public DaoAuthenticationProvider authProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userService);
	    authProvider.setPasswordEncoder(encoder());
	    return authProvider;
	}

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }
    
    @Bean
    public AuthenticationEntryPoint http403ForbiddenEntryPoint() {
    	// Custom Http403ForbiddenEntryPoint
	    return new AuthenticationEntryPoint() {
			@Override
			public void commence(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException authException) throws IOException, ServletException {
				request.setAttribute(WebAttributes.ACCESS_DENIED_403, authException);
				response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		        ResponseEnvelope<String> envelop = new ResponseEnvelope<>();
				envelop.setStatus(HttpServletResponse.SC_FORBIDDEN);
				envelop.setCode(126);
				envelop.setDevMsg("N/A");
				envelop.setTimestamp(getTimestampNowTxt());
				envelop.setPayload(authException.getMessage());
				ObjectMapper mapper = new ObjectMapper();
				String json = mapper.writeValueAsString(envelop);
		        response.getWriter().write(json);
			}
	    };
    }
    
    // DO NOT USE ACCESS DENIED HANDLER
    /*
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
    	return new AccessDeniedHandler() {
			@Override
			public void handle(HttpServletRequest request, HttpServletResponse response,
					AccessDeniedException accessDeniedException) throws IOException, ServletException {
				// response.sendError(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase());
				response.sendError(HttpStatus.FORBIDDEN.value(),
					APIResponse.payload("Fordding, You are not allowed to access to this resource.")
						  .devMsg("N/A")
						  .code(126)
						  .forbidden()
						  .responseEntity(Object.class).toString());
				// Put exception into request scope (perhaps of use to a view)
				request.setAttribute(WebAttributes.ACCESS_DENIED_403, accessDeniedException);
				// Set the 403 status code.
				response.setStatus(HttpStatus.FORBIDDEN.value());
				
			}
    		
    	};
    }
    */
	
}
