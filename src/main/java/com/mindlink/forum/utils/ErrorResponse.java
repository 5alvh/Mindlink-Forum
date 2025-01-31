package com.mindlink.forum.utils;

import java.time.LocalDate;

public class ErrorResponse {
    private String message;
    private int statusCode;
    private LocalDate timestamp;

    public ErrorResponse(String message, int statusCode, LocalDate timestamp) {
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }
}
