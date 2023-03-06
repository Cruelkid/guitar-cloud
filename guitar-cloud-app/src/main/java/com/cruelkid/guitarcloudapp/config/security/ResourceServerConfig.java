package com.cruelkid.guitarcloudapp.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static com.cruelkid.guitarcloudapp.constants.ConfigConstants.READ_SCOPE;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests()
                .requestMatchers("/guitars/**")
                .hasAuthority(READ_SCOPE)
                .and()
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

        return httpSecurity.build();
    }

}
