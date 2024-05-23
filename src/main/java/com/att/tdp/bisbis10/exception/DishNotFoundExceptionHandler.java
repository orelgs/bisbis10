package com.att.tdp.bisbis10.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DishNotFoundExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DishNotFoundException.class)
    public ErrorItem handleDishNotFoundException(DishNotFoundException exception) {
        return new ErrorItem(exception.getMessage());
    }
}
