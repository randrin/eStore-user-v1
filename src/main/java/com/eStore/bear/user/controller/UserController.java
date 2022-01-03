package com.eStore.bear.user.controller;

import com.eStore.bear.user.dto.User;
import com.eStore.bear.user.service.UserService;
import com.eStore.bear.user.utils.UserEndpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserEndpoints.USER_ROOT)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(UserEndpoints.SAVE_USER)
    public ResponseEntity<User> saveUser(@RequestBody User user) {

        return userService.saveUser(user);
    }
}
