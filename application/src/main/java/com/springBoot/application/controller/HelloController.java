package com.springBoot.application.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {



    @GetMapping("/")
    public String  helloworld() {
        return "Hi Welcome to my application asdas";
    }
}
