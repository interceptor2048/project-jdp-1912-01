package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.TokenNotFoundException;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserNotFoundException;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Component
public class DbUserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(final Long id) throws UserNotFoundException {
        return userRepository.findById(id);
    }

    public void deleteUser(final Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    public User updateUser(final Long id, User user) throws UserNotFoundException {
        User toUpdate = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        toUpdate.setUsername(user.getUsername());
        toUpdate.setToken(user.getToken());
        toUpdate.setIsBlocked(user.getIsBlocked());
        return userRepository.save(toUpdate);
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public void blockUser(final User user) {
        if (userRepository.existsById(user.getId())) {
            User userToBlock = userRepository.getOne(user.getId());
            if (userToBlock.getIsBlocked().equals(false)) {
                userToBlock.setIsBlocked(true);
            } else {
                userToBlock.setIsBlocked(false);
            }
            userRepository.save(userToBlock);
        }
    }

    public void generateToken(final Long id) throws TokenNotFoundException {
        String userTokenGeneration = "";
        if (userRepository.existsById(id)) {
            userTokenGeneration = tokenGeneration();
            userRepository.getOne(id).setToken(userTokenGeneration);
        }
    }

    private String tokenGeneration() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String token = bytes.toString();
        return token;
    }
}