package com.mromanode.springstore.User;

import com.mromanode.springstore.SpringstoreApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/users/", produces = "application/vnd.mromanode.users.v1+json")
public class UserController {

    private final UserService userService;
    private static final Logger logger = LogManager.getLogger(SpringstoreApplication.class);


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable UUID id) {
        logger.info("Invoked request: get user by ID: {}", id);
        Optional<User> user = userService.getUserById(id);
        if (user.isEmpty()) {
            logger.error("Unexpected error: user with ID {} not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        logger.info("Found user: by ID {}", id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/firstname/{firstname}")
    public ResponseEntity<Set<User>> findUserByFirstNameIgnoreCase(@PathVariable String firstname) {
        logger.info("Invoked request: get user by first name: {}", firstname);
        Set<User> users = userService.findUserByFirstNameIgnoreCase(firstname);
        if (users.isEmpty()) {
            logger.error("Unexpected error: user with first name {} not found", firstname);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        logger.info("Found users: by first name {}", firstname);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/lastname/{lastname}")
    public ResponseEntity<Set<User>> findUserByLastNameIgnoreCase(@PathVariable String lastname) {
        logger.info("Invoked request: get user by last name: {}", lastname);
        Set<User> users = userService.findUserByLastNameIgnoreCase(lastname);
        if (users.isEmpty()) {
            logger.error("Unexpected error: user with last name {} not found", lastname);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        logger.info("Found users: by last name {}", lastname);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<Optional<User>> findUserByEmailIgnoreCase(@PathVariable String email) {
        logger.info("Invoked request: get user by email: {}", email);
        Optional<User> user = userService.findUserByEmailIgnoreCase(email);
        if (user.isEmpty()) {
            logger.error("Unexpected error: user with email {} not found", email);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        logger.info("Found user: by email {}", email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        logger.info("Invoked request: save user {}", user);
        logger.warn("Saving user: {}", user);
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public void updateUserById(@PathVariable UUID id, @RequestBody User user) {
        logger.info("Invoked request: update user info: by ID {}", id);
        logger.warn("Updating user info: by ID {}", id);
        userService.updateUserById(id, user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole(), user.getSalted());
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable UUID id) {
        logger.info("Invoked request: delete user: by ID {}", id);
        logger.warn("Deleting user: by ID {}", id);
        userService.delete(id);
    }

}
