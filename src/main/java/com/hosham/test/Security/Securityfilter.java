package com.hosham.test.Security;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException; 
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class Securityfilter extends OncePerRequestFilter   {

	private Securitymanager securitymanager;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException {
		
		String key = String.valueOf(request.getHeader("key"));
		SecurityAuthen sa = new SecurityAuthen(false, key);
		
		var a = securitymanager.authenticate(sa);
		
		if(a.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(a);
		filterChain.doFilter(request, response);
		}
		
	}

}
