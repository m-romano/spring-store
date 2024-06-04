package com.mromanode.springstore.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String role;

    // The email will be used to identify the user when login.
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String salted;
}
