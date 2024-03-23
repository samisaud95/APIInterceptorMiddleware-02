package com.example.APIInterceptorMiddleware02.interceptor;

import com.example.APIInterceptorMiddleware02.entity.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class MonthInterceptor implements HandlerInterceptor {
private final List<Month> monthList = new ArrayList<>(Arrays.asList(
        new Month(1,"January","Gennaio","Januar."),
        new Month(2,"February","Febraio","Februar"),
        new Month(3,"March","Marzo","März"),
        new Month(4,"April","Aprile"," April"),
        new Month(5,"June","Junnio","Juni"),
        new Month(6,"July","Luglio","Juli")
));

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("BasicAutthearder");
        String monthNumberHeader = request.getHeader("monthNumber");


        // if monthNumber is null returns an HTTP Bad Request error
        if (monthNumberHeader == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Monthnumberheader is missing");
            return false;
        }
        // if monthNumber is empty returns an HTTP Bad Request error
        if (monthNumberHeader.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Monthnumberheader is empty");
            return false;
        }

        // If monthNumber is not in the list else, returns an empty Month with all the string values set not
        Month month = find(Integer.valueOf(monthNumberHeader));
        request.setAttribute("month", Objects.requireNonNullElseGet(month, () -> new Month(null, "not", "no", "notingerman")));
        response.setStatus(HttpStatus.OK.value());
        return true;
    }

    //looks if the passed monthNumber is present in the list
    //if present, returns it using a specific request attribute
    //returns an HTTP OK status
    private Month find(Integer integer) {
        for (Month month : monthList) {
            if (month.getMonthNumber().equals(integer)) {
                return month;
            }
        }
        return null;
    }

}

