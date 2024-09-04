package com.Microservices.GestionUtilisateurs_service.Controller;

import com.Microservices.GestionUtilisateurs_service.Model.Dto.UserDTO;
import com.Microservices.GestionUtilisateurs_service.Model.Entity.AuthResponse;
import com.Microservices.GestionUtilisateurs_service.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthService Service;

@PostMapping("/Auth/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody UserDTO user){
    return ResponseEntity.ok(Service.register(user));
}
    @PostMapping("/Auth/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody UserDTO user){
        return ResponseEntity.ok(Service.authenticate(user));
    }
}
