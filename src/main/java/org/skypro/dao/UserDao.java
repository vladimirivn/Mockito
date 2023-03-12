package org.skypro.dao;

import org.skypro.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);
    List<User> findAllUsers();
}
