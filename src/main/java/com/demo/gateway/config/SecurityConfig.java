package com.demo.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	SecurityFilterChain securityFilterChainn(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
		.and()
		.build();
		return null;
	}
	
	UserDetailsManager userDetailsManager() {
		
		var v = new InMemoryUserDetailsManager();
		var u1 = User.withUsername("suraj").password("suraj@123").authorities("read").build();
		var u2 = User.withUsername("admin").password("admin").authorities("read","write").build();
		var u3 = User.withUsername("user").password("admin").authorities("read").build();
		v.createUser(u1);
		v.createUser(u2);
		v.createUser(u3);
		return v;
	}
	
	PasswordEncoder passwordEncder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
