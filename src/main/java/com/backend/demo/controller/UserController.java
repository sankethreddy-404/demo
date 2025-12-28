package com.backend.demo.controller;
import com.backend.demo.model.User;
import org.springframework.web.bind.annotation.*;
@RestController
public class UserController {
    @PostMapping("/user")
    public User createuser(@RequestBody User user){
        return user;
    }
}
