package com.dev.spring_boot_rest_api_basics.model;

public class HelloWorldModel {
    private String message;

    public HelloWorldModel() {
    }
    public HelloWorldModel(String message) {
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
        return "HelloWorldModel{" +
                "message='" + message + '\'' +
                '}';
    }
}
