package com.javatechie.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.javatechie.entity.UserCredentials;
import com.javatechie.repository.UserCredentialsRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserCredentialsRepository repository;

	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			Optional<UserCredentials> credential = repository.findByName(username);
		return credential.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("user Not Found with name:"+username));	
	}

}
