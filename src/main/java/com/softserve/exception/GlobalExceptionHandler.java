package com.softserve.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NullEntityReferenceException.class)
    public ModelAndView nullEntityReferenceHandleException(NullEntityReferenceException exception) {
        ModelAndView modelAndView = new ModelAndView("error-400", HttpStatus.BAD_REQUEST);
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ModelAndView entityNotFoundHandleException(EntityNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView("error-404", HttpStatus.NOT_FOUND);
        modelAndView.addObject("message", e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView internalServerErrorException(Exception exception) {
        ModelAndView modelAndView = new ModelAndView("error-500", HttpStatus.INTERNAL_SERVER_ERROR);
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ModelAndView accessDeniedErrorHandler(Exception exception) {
        ModelAndView modelAndView = new ModelAndView("accessDenied", HttpStatus.INTERNAL_SERVER_ERROR);
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }
}
