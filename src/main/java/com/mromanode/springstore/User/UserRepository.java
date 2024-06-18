package com.mromanode.springstore.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> getUserById(UUID id);
    Set<User> findUserByFirstNameIgnoreCase(String firstName);
    Set<User> findUserByLastNameIgnoreCase(String lastName);
    Optional<User> findUserByEmailIgnoreCase(String email);

    @Modifying
    @Query("update User u set u.firstName = ?1, u.lastName = ?2, u.email = ?3, u.role = ?4, u.salted = ?5 where u.id = ?6")
    void updateUserById(String firstName, String lastName, String email, String role, String salted, UUID id);
}
