package com.backend.demo.controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Backend is working";
    }
    @GetMapping("/hellopath/{name}")
    public String  hellopath(@PathVariable String name){
        return "Hello " + name + " backend is working";
    }
    @GetMapping("/greet")
    public String greet(@RequestParam String name){
        return "Welcome "+ name;
    }



}
