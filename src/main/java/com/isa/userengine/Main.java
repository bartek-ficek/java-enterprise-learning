package com.isa.userengine;

import com.isa.userengine.repository.UserRepository;
import com.isa.userengine.repository.UserRepositoryBean;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryBean();
        userRepository.findAll().forEach(user -> System.out.println(user.getName()));
    }
}
