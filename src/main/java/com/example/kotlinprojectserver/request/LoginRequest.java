package com.example.kotlinprojectserver.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String memberId;
    private String password;
}
