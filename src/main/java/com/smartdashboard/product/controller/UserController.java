package com.smartdashboard.product.controller;

import com.smartdashboard.product.model.User;
import com.smartdashboard.product.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/profile/{username}")
    public ResponseEntity<?> getUserProfile(@PathVariable String username) {
        return userRepository.findByUsername(username)
                .<ResponseEntity<?>>map(user -> ResponseEntity.ok(user))
                .orElse(ResponseEntity.status(404).body("User not found: " + username));
    }
    @PutMapping("/profile/update")
    public ResponseEntity<?> updateProfile(@RequestBody User userDetails) {

        return userRepository.findById(userDetails.getId())
                .<ResponseEntity<?>>map(user -> {
                    user.setUsername(userDetails.getUsername());
                    user.setEmail(userDetails.getEmail());
                    return ResponseEntity.ok(userRepository.save(user));
                })
                .orElse(ResponseEntity.status(404).body("User not found"));
    }}