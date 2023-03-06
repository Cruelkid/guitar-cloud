package com.cruelkid.gcapiclient.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authorize ->
                authorize.anyRequest().authenticated()
        )
        .oauth2Login(oauth2Login ->
                oauth2Login.loginPage("/oauth2/authorization/guitar-cloud-client-oidc")
        )
        .oauth2Client(Customizer.withDefaults());

        return httpSecurity.build();
    }

}
