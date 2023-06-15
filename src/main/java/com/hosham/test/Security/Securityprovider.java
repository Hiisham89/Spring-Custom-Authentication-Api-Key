package com.hosham.test.Security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


@Component
public class Securityprovider implements AuthenticationProvider {
	
	@Value("${very.secret.key}")
	private  String key;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		SecurityAuthen filter = (SecurityAuthen) authentication;
		String headerkey = filter.getKey();
		if(key.equals(headerkey)) {
		return new SecurityAuthen(true,null);}
		
		throw new BadCredentialsException("ho no!");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return SecurityAuthen.class.equals(authentication);
	}
	
	}


