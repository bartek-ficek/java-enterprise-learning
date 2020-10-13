package com.isa.userengine.service;

import com.isa.userengine.domain.User;
import com.isa.userengine.repository.UserRepository;
import com.isa.userengine.repository.UserRepositoryBean;

public class UserService {

    private UserRepository userRepository = new UserRepositoryBean();

    public void save(User user){
        userRepository.save(user);
    }

    public User findById(Long id){
        return userRepository.findById(id);
    }
}
