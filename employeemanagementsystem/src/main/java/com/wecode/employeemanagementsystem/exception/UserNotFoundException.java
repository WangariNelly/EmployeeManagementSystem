package com.wecode.employeemanagementsystem.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException (String message) {
    super(message);
    }
}
