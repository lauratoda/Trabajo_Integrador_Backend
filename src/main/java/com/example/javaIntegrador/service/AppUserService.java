package com.example.javaIntegrador.service;

import com.example.javaIntegrador.model.AppUser;
import com.example.javaIntegrador.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Transactional
@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        AppUser user = userRepository.findByUsername(username);
//
//        UserDetails userDetails = new User(username, user.getPassword(),
//                Arrays.asList(new SimpleGrantedAuthority("ROLE_" + user.getRole().name())));
//
//        return userDetails;
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        AppUser user = userRepository.findByEmail(email).get();

        UserDetails userDetails = new User(email, user.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority("ROLE_" + user.getRole().name())));

        return userDetails;
    }
}

/*
@Service
public class AppUserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public AppUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email){

        return userRepository.findByEmail(email).get();
    }
}
 */