package com.isa.userengine.cdi;

import com.isa.userengine.domain.User;
import com.isa.userengine.repository.UserRepository;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.Random;

@RequestScoped
public class RandomUserCDIRequestDaoBean implements RandomUserCDIRequestDao {

    @EJB
    private UserRepository userRepositoryBean;

    @Override
    public User getRandomUser() {
        return userRepositoryBean.findAll().get(new Random().nextInt(3));
    }
}
