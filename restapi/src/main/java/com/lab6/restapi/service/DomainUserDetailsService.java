package com.lab6.restapi.service;

import com.lab6.restapi.entity.DomainUserDetails;
import com.lab6.restapi.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DomainUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepo.findByUsername(username).map(DomainUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Wrong credentials"));
    }

}
