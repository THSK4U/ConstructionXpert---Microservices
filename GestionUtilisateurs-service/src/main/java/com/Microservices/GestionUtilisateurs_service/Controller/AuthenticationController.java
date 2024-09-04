package com.Microservices.GestionUtilisateurs_service.Controller;

import com.Microservices.GestionUtilisateurs_service.Model.Dto.UserDTO;
import com.Microservices.GestionUtilisateurs_service.Model.Entity.AuthResponse;
import com.Microservices.GestionUtilisateurs_service.Service.AuthService;
import com.Microservices.GestionUtilisateurs_service.Service.securitySevice.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthService Service;

    @Autowired
    private JwtService JWTService;

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

    @GetMapping("/Auth/validate")
    public ResponseEntity<String> validateToken(@RequestParam("token") String token) {
        JWTService.validateToken(token);
        return ResponseEntity.ok("Token is valid");
    }

}
