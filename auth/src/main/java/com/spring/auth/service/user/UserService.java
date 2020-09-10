package com.spring.auth.service.user;

import com.spring.auth.domain.request.SignUpRequest;

public interface UserService {
    void signup(SignUpRequest signUpRequest);
}