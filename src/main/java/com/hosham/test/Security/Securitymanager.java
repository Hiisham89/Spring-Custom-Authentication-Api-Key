package com.hosham.test.Security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class Securitymanager implements AuthenticationManager {

	private final Securityprovider securityprovider;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if(securityprovider.supports(authentication.getClass())) {
		return securityprovider.authenticate(authentication);  
		}
		throw new BadCredentialsException("ho no!");

	}
}
