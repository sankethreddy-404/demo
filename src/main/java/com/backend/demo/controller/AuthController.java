package com.backend.demo.controller;

import com.backend.demo.dto.AuthRequest;
import com.backend.demo.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtUtil jwtUtil;
    public AuthController(JwtUtil jwtUtil){
        this.jwtUtil=jwtUtil;
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request){
        if("admin".equals(request.username())&& "password".equals(request.password())){
            String token=jwtUtil.generateToken(request.username());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

}
