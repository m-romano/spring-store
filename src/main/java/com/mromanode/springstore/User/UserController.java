package com.mromanode.springstore.User;

import com.mromanode.springstore.SpringstoreApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private static final Logger logger = LogManager.getLogger(SpringstoreApplication.class);


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public Optional<User> getUserById(@PathVariable("id") UUID id) {
        logger.info("Invoked request: get user by ID: {}", id);
        logger.warn("Searching for user: by ID {}", id);
        Optional<User> user = userService.getUserById(id);
        if (user.isEmpty()) {
            logger.error("Unexpected error: user with ID {} not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        logger.info("Found user: by ID {}", id);
        return user;
    }

    @GetMapping(value = "/firstname/{firstname}")
    public Set<User> getUserByFirstNameIgnoreCase(@PathVariable("firstname") String firstname) {
        logger.info("Invoked request: get user by first name: {}", firstname);
        logger.warn("Searching for users: by first name {}", firstname);
        Set<User> users = userService.getUserByFirstNameIgnoreCase(firstname);
        if (users.isEmpty()) {
            logger.error("Unexpected error: user with first name {} not found", firstname);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        logger.info("Found users: by first name {}", firstname);
        return users;
    }

    @GetMapping(value = "/lastname/{lastname}")
    public Set<User> getUserByLastNameIgnoreCase(@PathVariable("lastname") String lastname) {
        logger.info("Invoked request: get user by last name: {}", lastname);
        logger.warn("Searching for users: by last name {}", lastname);
        Set<User> users = userService.getUserByLastNameIgnoreCase(lastname);
        if (users.isEmpty()) {
            logger.error("Unexpected error: user with last name {} not found", lastname);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        logger.info("Found users: by last name {}", lastname);
        return users;
    }

    @GetMapping(value = "/email/{email}")
    public Optional<User> getUserByEmailIgnoreCase(@PathVariable("email") String email) {
        logger.info("Invoked request: get user by email: {}", email);
        logger.warn("Searching for user: by email {}", email);
        Optional<User> user = userService.getUserByEmailIgnoreCase(email);
        if (user.isEmpty()) {
            logger.error("Unexpected error: user with email {} not found", email);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        logger.info("Found user: by email {}", email);
        return user;
    }

    @PostMapping
    public User save(@RequestBody User user) {
        logger.info("Invoked request: save user {}", user);
        logger.warn("Saving user: {}", user);
        return userService.save(user);
    }

    @PutMapping(value = "/{id}")
    public void updateUserById(@PathVariable("id") UUID id, @RequestBody User user) {
        logger.info("Invoked request: update user info: by ID {}", id);
        logger.warn("Updating user info: by ID {}", id);
        userService.updateUserById(id, user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole(), user.getSalted());
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") UUID id) {
        logger.info("Invoked request: delete user: by ID {}", id);
        logger.warn("Deleting user: by ID {}", id);
        userService.delete(id);
    }

}
