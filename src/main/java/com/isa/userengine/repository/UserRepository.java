package com.isa.userengine.repository;

import com.isa.userengine.domain.User;
import java.util.List;

public interface UserRepository {
    void save(User user);

    User findById(int id);

    User findByLogin(String login);

    List<User> findAll ();

}
