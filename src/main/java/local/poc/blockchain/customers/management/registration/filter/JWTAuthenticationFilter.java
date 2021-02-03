package local.poc.blockchain.customers.management.registration.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import local.poc.blockchain.customers.management.registration.datobj.dto.AliasPasswordDTO;
import local.poc.blockchain.customers.management.registration.persistence.model.User;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private JWTParams jwtParams;
	
	private AuthenticationManager authenticationManager;
	
	public JWTAuthenticationFilter
	(AuthenticationManager authenticationManager,
	 JWTParams jwtParams) {
		this.authenticationManager = authenticationManager;
		this.jwtParams = jwtParams;
		setFilterProcessesUrl("/ureg/v1/pass");
	}
	
	@Override
    public Authentication attemptAuthentication
    (HttpServletRequest req, HttpServletResponse res)
    throws AuthenticationException {
        try {
        	AliasPasswordDTO creds = new ObjectMapper()
                    				.readValue(req.getInputStream(),
                    						   AliasPasswordDTO.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getAlias(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth)
    throws IOException {
        String token = JWT.create()
                .withSubject(((User) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtParams.getExpirationDate()))
                .sign(Algorithm.HMAC512(jwtParams.getSecret().getBytes()));
        res.getWriter().write(token);
        res.getWriter().flush();
    }
	
}
