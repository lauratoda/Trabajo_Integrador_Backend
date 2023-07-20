package com.example.javaIntegrador.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String username;
    private String password;
    @Enumerated
    private AppUserRole role;

    public AppUser(String nombre, String email, String username, String password, AppUserRole role) {
        this.nombre = nombre;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
