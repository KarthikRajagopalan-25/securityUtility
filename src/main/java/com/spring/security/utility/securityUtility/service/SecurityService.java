package com.spring.security.utility.securityUtility.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.utility.securityUtility.entity.Customer;
import com.spring.security.utility.securityUtility.entity.SecurityCustomer;
import com.spring.security.utility.securityUtility.repository.CustomerRepository;

@Service
public class SecurityService  implements UserDetailsService{

	@Autowired
	public CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		List<Customer> customer = customerRepository.findByEmail(username);
		if(Objects.isNull(customer)) {
			throw new UsernameNotFoundException(username);
		}
		
		return  new SecurityCustomer(customer.get(0));
	}

}
