package com.dauphine.blogger.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(
        name="Hello world API",
        description = "My first hello world endpoints"
)
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
    @Operation(
            summary = "Hello by name endpoint",
            description = "Returns 'Hello {name} by path variable"
    )
    public String hello(
            @Parameter(description = "Name to greet")
            @PathVariable String name){
        return "hello-world " + name;
    }
}
