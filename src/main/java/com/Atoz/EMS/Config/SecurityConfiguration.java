package com.Atoz.EMS.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    @Order(1)
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.securityMatcher(AntPathRequestMatcher.antMatcher("/h2-console/**"))
        .authorizeHttpRequests(auth->{
            auth.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll();
        })
        .csrf(csrf->csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")))
        .headers(headers->headers.frameOptions(frameOptions->frameOptions.disable()));
        return httpSecurity.build();
        
        }
}
