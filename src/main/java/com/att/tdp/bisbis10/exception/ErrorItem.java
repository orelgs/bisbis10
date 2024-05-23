package com.att.tdp.bisbis10.exception;

import java.util.Date;

public class ErrorItem {
    private String errorMessage;
    private Date date;

    public Date getDate() {
        return date;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ErrorItem(String errorMessage) {
        this.errorMessage = errorMessage;
        this.date = new Date();
    }
}
