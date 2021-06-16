package com.example.servlet;

import org.springframework.stereotype.Component;

@Component
public class HelloService {

    public String getHelloName() {
        return "Wooteco";
    }
}
