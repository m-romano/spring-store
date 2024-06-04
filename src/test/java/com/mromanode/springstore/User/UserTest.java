package com.mromanode.springstore.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;
    private UUID userId;

    @BeforeEach
    void setUp() {
        user = new User();
        userId = UUID.randomUUID();
        user.setId(userId);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setRole("user");
        user.setEmail("john@doe.com");
        user.setSalted("[1+2@3#4Qf");
    }

    @Test
    void creteUser() {
        assertEquals(user.getId(), userId);
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("user", user.getRole());
        assertEquals("john@doe.com", user.getEmail());
        assertEquals("[1+2@3#4Qf", user.getSalted());
    }

    @Test
    void updateUser() {
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setRole("admin");
        user.setEmail("jane@doe.com");
        user.setSalted("!£$123");

        assertEquals(user.getId(), userId);
        assertEquals("Jane", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("jane@doe.com", user.getEmail());
        assertEquals("!£$123", user.getSalted());
    }
}
