package com.utosoftware.mk.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.utosoftware.mk.entity.UserEntity;
import com.utosoftware.mk.model.User;
import com.utosoftware.mk.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
// save
	@Override
	public User saveUser(User user) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		userRepository.save(userEntity);
		
		return user;
	}

// findAll
	@Override
	public List<User> getAllUsers() {
		List<UserEntity> listUsers = userRepository.findAll();
		
		List<User> users = listUsers
				.stream()
				.map(userEntity -> new User(
							userEntity.getId(),
							userEntity.getUsername(),
							userEntity.getEmailId(),
							userEntity.getPassword()
						))
				.collect(Collectors.toList());
		
		return users;
	}

//findById
	@Override
	public User getUserById(Long id) {
		UserEntity userEntitty = userRepository.findById(id).get();
		User user = new User();
		BeanUtils.copyProperties(userEntitty, user);
		return user;
	}
	

}
