package com.oauth2.AuthorizationServer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration(proxyBeanMethods = false)
public class DefaultSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain (HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(auth ->
                                auth
//                                        .requestMatchers(HttpMethod.GET, "/logged-out").permitAll()
//                                        .requestMatchers(HttpMethod.GET,"/test").authenticated()
//                                        .requestMatchers(HttpMethod.GET,"/students").authenticated()
                                        .anyRequest().authenticated()
                );
        httpSecurity.oauth2Login(oauth2login ->
                oauth2login
//                        .loginPage("/login"));
                        .loginPage("/oauth2/authorization/users-client-oidc"));
        httpSecurity.oauth2Client(Customizer.withDefaults());

        return httpSecurity.build();
    }
}
