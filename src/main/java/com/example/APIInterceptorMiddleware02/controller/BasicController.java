package com.example.APIInterceptorMiddleware02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @GetMapping
    public String welcome(){
        return " welcome the user on the root mapping";
    }

}
