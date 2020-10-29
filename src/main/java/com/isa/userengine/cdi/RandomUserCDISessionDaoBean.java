package com.isa.userengine.cdi;

import com.isa.userengine.domain.User;
import com.isa.userengine.repository.UserRepository;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import java.util.Random;


@SessionScoped
public class RandomUserCDISessionDaoBean implements RandomUserCDISessionDao, java.io.Serializable {

    @EJB
    private UserRepository userRepositoryBean;

    @Override
    public User getRandomUser() {
        return userRepositoryBean.findAll().get(new Random().nextInt(3));
    }

}
