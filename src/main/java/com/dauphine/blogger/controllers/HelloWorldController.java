package com.dauphine.blogger.controllers;


import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


    @GetMapping("hello-world")
    public String helloWorld(){
        return "hello-world";
    }

    //Request param
    @GetMapping("hello")
    public String helloWorldByName(@RequestParam String name){
        return "hello-world " + name;
    }

    //Path Variable
    @GetMapping("hello/{name}")
    public String hello(@PathVariable String name){
        return "hello-world " + name;
    }
}
