package com.isa.userengine.service;

import com.isa.userengine.domain.User;
import com.isa.userengine.repository.UserRepository;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class UserService {

    @EJB
    private UserRepository userRepositoryBean;

    public void save(User user){
        userRepositoryBean.save(user);
    }

    public User findById(Long id){
        return userRepositoryBean.findById(id);
    }
}
