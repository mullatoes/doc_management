package com.example.doc_management.service;

import com.example.doc_management.dto.UserSignUpRequest;
import com.example.doc_management.model.User;
import com.example.doc_management.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean authenticateUser(String email, String password) {
        User user = findByEmail(email);

        if (user != null) {
            return password.equals(user.getPassword());
        }
        return false;
    }

    public User registerUser(UserSignUpRequest userSignUpRequest) {
        String username = userSignUpRequest.getUsername();
        String email = userSignUpRequest.getEmail();
        String password = userSignUpRequest.getPassword();

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        return userRepository.save(user);
    }
}
