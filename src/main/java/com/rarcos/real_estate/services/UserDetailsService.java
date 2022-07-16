package com.rarcos.real_estate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rarcos.real_estate.models.User;
import com.rarcos.real_estate.repositories.UserRepository;
 
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
 
    @Autowired
    private UserRepository repository;
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
 
        return user;
 
    }
 
}