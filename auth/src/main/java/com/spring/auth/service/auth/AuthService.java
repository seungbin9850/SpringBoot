package com.spring.auth.service.auth;

import com.spring.auth.domain.request.SignInRequest;
import com.spring.auth.domain.response.TokenResponse;

public interface AuthService {
    TokenResponse login(SignInRequest signInRequest);
    TokenResponse refreshToken(String refreshToken);
}