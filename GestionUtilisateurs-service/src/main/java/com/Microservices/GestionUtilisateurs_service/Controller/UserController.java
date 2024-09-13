package com.Microservices.GestionUtilisateurs_service.Controller;


import com.Microservices.GestionUtilisateurs_service.Model.Dto.UserDTO;
import com.Microservices.GestionUtilisateurs_service.Service.AuthService;
import com.Microservices.GestionUtilisateurs_service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Auth/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAccount() {
        return ResponseEntity.ok(userService.GetAllUser());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
