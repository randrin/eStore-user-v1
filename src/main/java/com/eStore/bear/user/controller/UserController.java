package com.eStore.bear.user.controller;

import com.eStore.bear.user.dto.User;
import com.eStore.bear.user.service.UserService;
import com.eStore.bear.user.utils.UserEndpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(UserEndpoints.USER_ROOT)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(UserEndpoints.SAVE_USER)
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {

        return userService.saveUser(user);
    }

    @GetMapping(UserEndpoints.FIND_USER)
    public ResponseEntity<User> findUserByEmail(@RequestParam String email) {
        return userService.findUserByEmail(email);
    }
}
