package com.example.doc_management.controller;

import com.example.doc_management.dto.UserSignInRequest;
import com.example.doc_management.dto.UserSignUpRequest;
import com.example.doc_management.model.User;
import com.example.doc_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody UserSignInRequest signInRequest) {
        String email = signInRequest.getEmail();
        String password = signInRequest.getPassword();

        if (userService.authenticateUser(email, password)) {
            return ResponseEntity.ok("Sign-in successful!");
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserSignUpRequest userSignUpRequest) {
        User user = userService.registerUser(userSignUpRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
