package com.mromanode.springstore.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Set<User> findByFirstName(String lastName);
    Set<User> findByLastName(String lastName);
    Set<User> findByEmail(String email);
    Set<User> findByFirstNameAndLastName(String firstName, String lastName);

}
