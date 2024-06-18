package com.mromanode.springstore.User;

import com.mromanode.springstore.SpringstoreApplication;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    private static final Logger logger = LogManager.getLogger(SpringstoreApplication.class);
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(UUID id) {
        logger.info("Invoked method: get user by ID: {}", id);
        logger.warn("Searching for user: by ID {}", id);
        Optional<User> user = userRepository.findById(id);
        logger.info("Found user: by ID {}", id);
        return user;
    }

    public Set<User> getUserByFirstNameIgnoreCase(String firstName) {
        logger.info("Invoked method: get user by first name: {}", firstName);
        logger.warn("Searching for user: by first name {}", firstName);
        Set<User> users = userRepository.getUserByFirstNameIgnoreCase(firstName);
        logger.info("Found user: by first name {}", firstName);
        return users;
    }

    public Set<User> getUserByLastNameIgnoreCase(String lastName) {
        logger.info("Invoked method: get user by last name: {}", lastName);
        logger.warn("Searching for user: by last name {}", lastName);
        Set<User> users = userRepository.getUserByLastNameIgnoreCase(lastName);
        logger.info("Found user: by last name {}", lastName);
        return users;
    }

    public Optional<User> getUserByEmailIgnoreCase(String email) {
        logger.info("Invoked method: get user by email: {}", email);
        logger.warn("Searching for user: by email {}", email);
        Optional<User> user = userRepository.getUserByEmailIgnoreCase(email);
        logger.info("Found user: by email {}", email);
        return user;
    }

    public User save(User user) {
        logger.info("Invoked method: save user: {}", user);
        logger.warn("Saving user: {}", user);
        User savedUser = userRepository.save(user);
        logger.info("Saved user: with ID {}", savedUser.getId());
        return savedUser;
    }

    public User updateUserById(UUID id, String firstName, String lastName, String email, String role, String salted) {
        logger.info("Invoked method: update user info: ID {}, firstName {}, lastName {}, email {}, role {}, salted {}", id, firstName, lastName, email, role, salted);
        logger.warn("Updating user info: by ID {}", id);
        User updatedUser = userRepository.updateUserById(firstName, lastName, email, role, salted, id);
        logger.info("Updated user info: by ID {}", id);
        return updatedUser;
    }

    public void delete(UUID id) {
        logger.info("Invoked method: delete user by ID {}", id);
        logger.warn("Deleting user: by ID {}", id);
        userRepository.deleteById(id);
        logger.info("Deleted user: by ID {}", id);
    }

}
