package com.example.javaIntegrador.config;

import com.example.javaIntegrador.model.AppUser;
import com.example.javaIntegrador.model.AppUserRole;
import com.example.javaIntegrador.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passPablo = passwordEncoder.encode("pablo");
        userRepository.save(new AppUser("Pablo", "pablo@dh.com", "pablo", passPablo, AppUserRole.USER));
        String passAdmin = passwordEncoder.encode("admin");
        userRepository.save(new AppUser("Admin", "admin@dh.com", "admin", passAdmin, AppUserRole.ADMIN));

    }
}
