package com.jproxy.app.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class JProxyController {
    @GetMapping("")
    public String helloWorld() {
        return "Hello, World!";
    }

}