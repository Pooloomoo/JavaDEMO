package com.demoJV.demoapp.models;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

public class ErrorDetails {
    private LocalDate timestamp;
    private String message;
    private String detail;

    public ErrorDetails(
            LocalDate timestamp,
            String message,
            String detail
    ){
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.detail = detail;
    }

    public LocalDate getLocalDate(){
        return timestamp;
    }

    public String getMessage(){
        return message;
    }

    public String getDetail(){
        return detail;
    }
}
