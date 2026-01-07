package com.backend.demo.dto;

import java.time.LocalDateTime;

public class APIResponse <T>{
    private int status;
    private String message;
    private LocalDateTime timeStamp;
    private T data;

    public APIResponse(LocalDateTime timeStamp,int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
