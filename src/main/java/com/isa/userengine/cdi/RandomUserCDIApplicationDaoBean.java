package com.isa.userengine.cdi;

import com.isa.userengine.domain.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RandomUserCDIApplicationDaoBean implements RandomUserCDIApplicationDao {
    @Override
    public User getRandomUser() {
        return null;
    }
}
