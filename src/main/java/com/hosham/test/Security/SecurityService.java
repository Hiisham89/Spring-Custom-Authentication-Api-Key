package com.hosham.test.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor

public class SecurityService {
	
	private final Securityfilter securityfilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.addFilterAt(securityfilter,UsernamePasswordAuthenticationFilter.class).
				authorizeHttpRequests(c->c.anyRequest().authenticated()).
				build();
	}

}
