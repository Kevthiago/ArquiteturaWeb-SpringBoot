package com.example.ex001.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloControler {
    @GetMapping("/testKevin")
    public String helloWorld() {
        return "Hello World! Este é meu código.";
    }
        
}
