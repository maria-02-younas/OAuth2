package com.oauth2.AuthorizationServer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class ResourceServerConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth ->
                        auth
                            .requestMatchers(HttpMethod.GET, "/test").hasAuthority("SCOPE_read")
                            .requestMatchers(HttpMethod.GET, "/students").hasAuthority("SCOPE_read")
                )
                .oauth2ResourceServer(httpSecurityOAuth2ResourceServerConfigurer ->
                                httpSecurityOAuth2ResourceServerConfigurer
                                .jwt(
                                        jwt -> jwt.decoder(
                        JwtDecoders.fromIssuerLocation("http://auth-server:9000")
                                    )
                            )
                );

        return httpSecurity.build();
    }
}