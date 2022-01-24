package com.eStore.bear.user.service;

import com.eStore.bear.user.dto.User;
import com.eStore.bear.user.exception.UserDataValidationException;
import com.eStore.bear.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordService passwordService;

    public ResponseEntity<User> saveUser(User user) {

        Optional<User> userNameFound = userRepository.findByName(user.getName());
        if (!userNameFound.isPresent()) {
            Optional<User> userEmailFound = userRepository.findByEmail(user.getEmail());
            if (!userEmailFound.isPresent()) {
                Optional<User> userMobileFound = userRepository.findByMobile(user.getMobile());
                if (!userMobileFound.isPresent()) {
                    user.setId(UUID.randomUUID().toString());
                    user.setInsertDate(new Date());
                    user.setPassword(passwordService.securePassword(user.getPassword()));
                    User userSaved = userRepository.save(user);
                    return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
                }
                throw new UserDataValidationException("User already exist with " + user.getMobile());
            }
            throw new UserDataValidationException("User already exist with " + user.getEmail());
        }
        throw new UserDataValidationException("User already exist with " + user.getName());
    }
}
