package com.example.APIInterceptorMiddleware02.controller;

import com.example.APIInterceptorMiddleware02.entity.Month;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/months")
public class MonthsController {
    @GetMapping
    public Month getMonth(HttpServletRequest request) {
        Month month = (Month) request.getAttribute("month");
        return month;
    }

}
