package com.utosoftware.mk.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utosoftware.mk.model.User;
import com.utosoftware.mk.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
    	return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
    	return userService.getAllUsers();
    }
	
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id ){
    	User user = null;
    	user = userService.getUserById(id);
    	return ResponseEntity.ok(user);
    	
    }
	
}
