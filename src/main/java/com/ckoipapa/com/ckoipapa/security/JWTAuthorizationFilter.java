
package com.ckoipapa.com.ckoipapa.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(
		HttpServletRequest arg0, HttpServletResponse arg1, FilterChain arg2)
		throws ServletException, IOException {
		
		arg1.addHeader("Access-Control-Allow-Origin", "*");
		arg1.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, " 
		+ "Access-Control-Request-Method, "
		+ "Access-Control-Request-Headers, "
		+ "Authorization");
		
		arg1.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, "
				+ "Access-Control-Allow-Credentials, Authorization");

		String jwt = arg0.getHeader(SecurityConstants.HEADER_STRING);
		System.out.println(jwt);
		
		if(arg0.getMethod().equals("OPTIONS")) {
			arg1.setStatus(HttpServletResponse.SC_OK);
		}else {
			if (jwt == null || !jwt.startsWith(SecurityConstants.TOKEN_PREFIX)) {
				arg2.doFilter(arg0, arg1);
				return;
			}

			Claims claims = Jwts.parser().setSigningKey(
				SecurityConstants.SECRET).parseClaimsJws(
					jwt.replace(SecurityConstants.TOKEN_PREFIX, "")).getBody();

			String username = claims.getSubject();
			ArrayList<Map<String, String>> roles =
				(ArrayList<Map<String, String>>) claims.get("roles");
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			roles.forEach(r->{
				authorities.add(new SimpleGrantedAuthority(r.get("authority")));
			});
			UsernamePasswordAuthenticationToken authenticatedUser = new UsernamePasswordAuthenticationToken(username, null, authorities);
			SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
			arg2.doFilter(arg0, arg1);
		}
		
		

	}

}
