package com.webservices.oms.ordermanagementsystem.security;

import com.webservices.oms.ordermanagementsystem.entity.Customer;
import com.webservices.oms.ordermanagementsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email:" + email));
        return new org.springframework.security.core.userdetails.User(customer.getEmail(),
                customer.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }

//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }
}
