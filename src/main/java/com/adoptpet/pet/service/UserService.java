package com.adoptpet.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adoptpet.pet.model.User;
import com.adoptpet.pet.repository.UserRepository;

@Service("userService")
public class UserService {

	private UserRepository userRepository;
	
    @Autowired
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user) {
        user.setPassword(user.getPassword());        
        userRepository.save(user);
    }
}
