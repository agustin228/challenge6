package org.binar.chapter6.service;

import org.binar.chapter6.model.Users;
import org.binar.chapter6.model.UsersDetailsImpl;
import org.binar.chapter6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
       Users user = userRepository.findByUsername(username).orElseGet(null);
        return UsersDetailsImpl.build(user);
    }


}
