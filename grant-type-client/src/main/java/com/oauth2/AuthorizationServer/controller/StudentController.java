package com.oauth2.AuthorizationServer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.security.Principal;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

//http://127.0.0.1:9000/oauth2/authorize?response_type=code&client_id=client&redirect_uri=http://127.0.0.1:8080/authorized&scope=openid%20read

@RestController
public class StudentController {
//    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private WebClient webClient;

//    @GetMapping("/api/hello")
//    public String hello(Principal principal) {
//        return "Hello " +principal.getName()+", Welcome to OAuth2 Example!!";
//    }

    @GetMapping("/test")
    public String users(
            @RegisteredOAuth2AuthorizedClient("client-authorization-code")
                    OAuth2AuthorizedClient client){
        return this.webClient
                .get()
                .uri("http://127.0.0.1:8090/test")
                .attributes(oauth2AuthorizedClient(client))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @GetMapping("/students")
    public String students(
            @RegisteredOAuth2AuthorizedClient("client-authorization-code")
                    OAuth2AuthorizedClient client){
        return this.webClient
                .get()
                .uri("http://127.0.0.1:8090/students")
                .attributes(oauth2AuthorizedClient(client))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}