package com.project.service;

import com.project.Model.User;
import com.project.Repository.UserRepository;
import com.project.dto.LoginRequest;
import com.project.dto.LoginResponse;
import com.project.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    public Optional<LoginResponse> login(LoginRequest loginRequest) {
        Optional<User> userOpt = userRepository.findByEmail(loginRequest.getEmail());

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPasswordHash())) {
                String token = jwtUtils.generateToken(user.getEmail());
                return Optional.of(new LoginResponse(
                        token,
                        user.getUserId(),
                        user.getEmail(),
                        user.getUserName()
                ));
            }
        }
        return Optional.empty();
    }
}
