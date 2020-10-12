package com.isa.userengine;

import com.isa.userengine.repository.UserRepositoryBean;

public class Main {
    public static void main(String[] args) {
        UserRepositoryBean userRepositoryBean = new UserRepositoryBean();
        userRepositoryBean.findAll().stream().forEach(user -> System.out.println(user.getName()));
    }
}
