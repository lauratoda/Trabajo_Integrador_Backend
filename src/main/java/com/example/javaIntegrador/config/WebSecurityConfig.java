package com.example.javaIntegrador.config;

import com.example.javaIntegrador.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private AppUserService appUserService;


  public void configure(AuthenticationManagerBuilder auth) {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(bCryptPasswordEncoder);
    provider.setUserDetailsService(appUserService);
    auth.authenticationProvider(provider);
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.csrf().disable()
            .authorizeRequests()
            .requestMatchers(HttpMethod.GET, "/pacientes/**", "/odontologos/**", "/turnos/**").hasAnyRole("USER", "ADMIN")
            .requestMatchers(HttpMethod.POST, "/pacientes/**", "/odontologos/**", "/turnos/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/pacientes/**", "/odontologos/**", "/turnos/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/pacientes/**", "/odontologos/**", "/turnos/**").hasRole("ADMIN")

            .anyRequest().authenticated().and().formLogin().and().logout();

    http.httpBasic();
    return http.build();
  }

}

