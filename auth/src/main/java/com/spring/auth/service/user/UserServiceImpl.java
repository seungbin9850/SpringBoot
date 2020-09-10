package com.spring.auth.service.user;

import com.spring.auth.domain.request.SignUpRequest;
import com.spring.auth.entity.User;
import com.spring.auth.entity.repository.UserRepository;
import com.spring.auth.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signup(SignUpRequest signUpRequest) {
        if (userRepository.findByEmail(signUpRequest.getEmail()).isPresent()) throw new UserAlreadyExistsException();
        String email = signUpRequest.getEmail();
        String name = signUpRequest.getName();
        String password = passwordEncoder.encode(signUpRequest.getPassword());

        userRepository.save(
                User.builder()
                .email(email)
                .password(password)
                .name(name)
                .build()
        );
    }
}
