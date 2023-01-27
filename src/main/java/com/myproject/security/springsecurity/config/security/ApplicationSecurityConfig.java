package com.myproject.security.springsecurity.config.security;

import com.myproject.security.springsecurity.config.permission.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.myproject.security.springsecurity.config.permission.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                authorizeRequests()
                .antMatchers("/", "index")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails ayesh = User.builder()
                .username("ayesh")
                .password(passwordEncoder.encode("1234"))
                .roles(CUSTOMER.name())
                .build();

        UserDetails dilshan = User.builder()
                .username("dilshan")
                .password(passwordEncoder.encode("1234"))
                .roles(MANAGER.name())
                .build();

        UserDetails nalaka = User.builder()
                .username("nalaka")
                .password(passwordEncoder.encode("1234"))
                .roles(ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(ayesh, dilshan, nalaka);
    }
}
