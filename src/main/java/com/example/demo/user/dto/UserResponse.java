package com.example.demo.user.dto;

public class UserResponse {
    private String nombre;
    private String apellido;

    public UserResponse(String nombre, String apellido) {
        this.nombre = nombre.toUpperCase();
        this.apellido = apellido.toUpperCase();
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
}
