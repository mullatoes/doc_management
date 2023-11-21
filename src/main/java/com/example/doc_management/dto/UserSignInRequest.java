package com.example.doc_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInRequest {

    private String email;
    private String password;
}
