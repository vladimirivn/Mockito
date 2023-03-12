package org.skypro.dao.impl;

import org.skypro.model.User;
import org.skypro.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final List<User> users = new ArrayList<>();

    public UserDaoImpl() {
        users.add(new User("Vladimir"));
        users.add(new User("Voldemar"));
        users.add(new User("Volodimir"));
    }

    @Override
    public User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }
}
