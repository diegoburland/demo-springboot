package com.learning.academy.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CustomExceptionHandler implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.error("Unhandled exception occurred:", ex);

        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "An unexpected error occurred. Please try again later.");
        mav.addObject("exception", ex);
        mav.setViewName("error"); // La vista que quieras mostrar en caso de excepción

        return mav;
    }
}