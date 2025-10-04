package com.example.demo.user.service;

import org.springframework.stereotype.Service;

import com.example.demo.user.dto.UserResponse;
import com.example.demo.user.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User(1L, "Juan", "Perez", "juan@mail.com"));
        users.add(new User(2L, "Maria", "Lopez", "maria@mail.com"));
        users.add(new User(3L, "Carlos", "Garcia", "carlos@mail.com"));
    }

    public UserResponse createUser(User user) {
        users.add(user);
        return new UserResponse(user.getNombre(), user.getApellido());
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(Long id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public String getNombreCompleto(String nombre, String apellido) {
        return nombre + " " + apellido;
    }
}
