package com.att.tdp.bisbis10.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PartialUpdateValueNotValidExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PartialUpdateValueNotValidException.class)
    public ErrorItem handlePartialUpdateValueNotValidException(PartialUpdateValueNotValidException exception) {
        return new ErrorItem(exception.getMessage());
    }
}
