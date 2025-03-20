package com.oauth2.AuthorizationServer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//http://127.0.0.1:9000/oauth2/authorize?response_type=code&client_id=client&redirect_uri=http://127.0.0.1:8080/authorized&scope=openid%20read

@RestController
public class StudentController {
    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping("/test")
    public String test1() {
        this.logger.warn("This is working message");
        return "Testing message";
    }

}