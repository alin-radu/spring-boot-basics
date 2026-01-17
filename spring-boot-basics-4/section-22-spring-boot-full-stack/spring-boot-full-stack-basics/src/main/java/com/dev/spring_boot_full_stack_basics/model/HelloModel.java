package com.dev.spring_boot_full_stack_basics.model;

public class HelloModel {
    private String message;

    public HelloModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean [message=" + message + "]";
    }
}
