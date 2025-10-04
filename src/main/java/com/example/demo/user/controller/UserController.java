package com.example.demo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.user.dto.UserResponse;
import com.example.demo.user.model.User;
import com.example.demo.user.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // 1️⃣ Crear usuario
    @PostMapping("/users")
    public UserResponse createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // 2️⃣ Obtener todos los usuarios
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // 3️⃣ Obtener usuario por ID
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // 4️⃣ Obtener nombre completo con parámetros
    @GetMapping("/params")
    public Map<String, String> getNombreCompleto(@RequestParam String nombre,
                                                 @RequestParam String apellido) {
        String nombreCompleto = userService.getNombreCompleto(nombre, apellido);
        return Map.of("nombreCompleto", nombreCompleto);
    }
}
