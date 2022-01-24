package com.spring.security.utility.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected
          void configure (HttpSecurity http) throws Exception {
		System.out.println("Inside securtiy");
		http.authorizeRequests()
		    .antMatchers("/utility/contact").permitAll()
		    .antMatchers("/utility/myNotice").permitAll()
		    .anyRequest().authenticated()
		    .and().httpBasic().and().formLogin();

		
	}

	//Using inmemoryUSER class and User details manager 
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)	 throws Exception{
		InMemoryUserDetailsManager detailsManager = new InMemoryUserDetailsManager();
		UserDetails user1 = User.builder().username("admin").authorities("admin").password("12345").build();
		UserDetails user2 = User.builder().username("user2").password("6789").authorities("read").build();
		detailsManager.createUser(user1);
		detailsManager.createUser(user2);
		auth.userDetailsService(detailsManager);
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
