package local.poc.blockchain.customers.management.registration.filter;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

import java.io.IOException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import local.poc.blockchain.customers.management.registration.service.UserService;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
	
	private JWTParams jwtParams;
	
	private UserService userService;
	
	public JWTAuthorizationFilter
	(AuthenticationManager authManager, JWTParams jwtParams, UserService userService) {
        super(authManager);
        this.jwtParams = jwtParams;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader("Authorization");
        
        if(header != null && header.startsWith("Bearer ")) {
        	UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        
        chain.doFilter(req, res);
    }

    // Reads the JWT from the Authorization header, and then uses JWT to validate the token
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
    	
    	UsernamePasswordAuthenticationToken result = null;
    	
        String auth = request.getHeader("Authorization");
        if (auth != null) {
        	Pattern pattern = Pattern.compile("^\\s*Bearer\\s+(.+)$", CASE_INSENSITIVE);
        	Matcher matcher = pattern.matcher(auth);
        	if(matcher.find()) {
	        	String token = matcher.group(1);
	        	String alias = JWT.require(Algorithm.HMAC512(jwtParams.getSecret().getBytes()))
	                    .build()
	                    .verify(token)
	                    .getSubject();
	            if (alias != null) {
	            	UserDetails userDetails = userService.loadUserByUsername(alias);
	            	Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
	                result = new UsernamePasswordAuthenticationToken(alias, null, authorities);
	            }
        	}
        }

        return result;
    }

}
