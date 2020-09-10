package com.spring.auth.service.auth;

import com.spring.auth.domain.request.SignInRequest;
import com.spring.auth.domain.response.TokenResponse;
import com.spring.auth.entity.User;
import com.spring.auth.entity.repository.UserRepository;
import com.spring.auth.exception.InvalidTokenException;
import com.spring.auth.exception.UserNotFoundException;
import com.spring.auth.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Value("${secret.prefix}")
    private String prefix;

    @Override
    public TokenResponse login(SignInRequest signInRequest) {
        User user = userRepository.findByEmail(signInRequest.getEmail())
                .filter(u -> passwordEncoder.matches(signInRequest.getPassword(), u.getPassword()))
                .orElseThrow(UserNotFoundException::new);

        return responseToken(user.getEmail());
    }

    @Override
    public TokenResponse refreshToken(String refreshToken) {
        if(!jwtTokenProvider.isRefreshToken(refreshToken)) throw new InvalidTokenException();
        String email = jwtTokenProvider.getUserEmail(refreshToken);
        return responseToken(email);
    }

    public TokenResponse responseToken(String email) {
        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(email))
                .refreshToken(jwtTokenProvider. generateRefreshToken(email))
                .tokenType(prefix)
                .build();
    }
}