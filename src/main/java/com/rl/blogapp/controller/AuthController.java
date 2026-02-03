package com.rl.blogapp.controller;

import com.rl.blogapp.dto.LoginRequest;
import com.rl.blogapp.dto.SignupRequest;
import com.rl.blogapp.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Authentication APIs",
        description = "APIs for user signup and login with JWT authentication"
)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


    @Operation(
            summary = "User Signup",
            description = "Register a new user and generate JWT access token"
    )
    @PostMapping("/signup")
    public ResponseEntity<?> signup(
            @RequestBody SignupRequest signupRequest
    ) {
        return new ResponseEntity<>(authService.signup(signupRequest), HttpStatus.CREATED);
    }

    @Operation(
            summary = "User Login",
            description = "Authenticate user and generate JWT access token"
    )
    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest loginRequest
    ) {
        return new ResponseEntity<>(authService.login(loginRequest), HttpStatus.OK);
    }
}
