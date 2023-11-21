package com.example.doc_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpRequest {
    private String username;
    private String email;
    private String password;
}
