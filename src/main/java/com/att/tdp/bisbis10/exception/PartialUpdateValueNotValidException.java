package com.att.tdp.bisbis10.exception;

public class PartialUpdateValueNotValidException extends RuntimeException {
    public PartialUpdateValueNotValidException(String errorMessage) {
        super(errorMessage);
    }
}
