package com.isa.userengine.repository;

import com.isa.userengine.domain.User;
import com.isa.userengine.storage.UserDb;
import java.util.List;

public class UserRepositoryBean implements UserRepository {
    @Override
    public void save(User user) {
        UserDb.getRepository().add(user);
    }

    @Override
    public User findById(int id) {
        return findAll().stream().
                filter(user -> (((Integer) user.getId()).equals(id))).
                findFirst().get();
    }

    @Override
    public User findByLogin(String login) {
        return findAll().stream().
                filter(user -> (user.getLogin().equals(login))).
                findFirst().get();
    }

    @Override
    public List<User> findAll() {
        return UserDb.getRepository();
    }
}
