package com.eStore.bear.user.service;

import com.eStore.bear.user.dto.User;
import com.eStore.bear.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<User> saveUser(User user) {

        user.setId(UUID.randomUUID().toString());
        user.setInsertDate(new Date());

       User userSaved = userRepository.save(user);

       return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
    }
}
