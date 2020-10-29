package com.isa.userengine.repository;

import com.isa.userengine.domain.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserRepository {
    void save(User user);

    User findById(Long id);

    User findByLogin(String login);

    List<User> findAll ();

}
