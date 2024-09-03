package com.Microservices.GestionUtilisateurs_service.Service;

import com.Microservices.GestionUtilisateurs_service.Model.Entity.AuthRequest;
import com.Microservices.GestionUtilisateurs_service.Model.Entity.AuthResponse;
import com.Microservices.GestionUtilisateurs_service.Model.Entity.user;
import com.Microservices.GestionUtilisateurs_service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public AuthResponse authenticate(AuthRequest authRequest) {
        user user = userRepository.findByUsername(authRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            String token = jwtTokenProvider.generateToken(user.getUsername());
            return new AuthResponse(token);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
