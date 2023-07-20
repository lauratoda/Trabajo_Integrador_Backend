package com.example.javaIntegrador.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController {

    @RequestMapping("/demo")
    public String showDemo(){
        return "Hello World from Demo";
    }



}
