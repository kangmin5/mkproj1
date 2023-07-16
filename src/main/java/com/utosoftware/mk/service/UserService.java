package com.utosoftware.mk.service;

import java.util.List;

import com.utosoftware.mk.model.User;

public interface UserService {

	User saveUser(User user);

	List<User> getAllUsers();

	User getUserById(Long id);

}
