package org.skypro.service.impl;

import org.skypro.model.User;
import org.skypro.dao.UserDao;
import org.skypro.dao.impl.UserDaoImpl;
import org.skypro.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

//    public UserServiceImpl() {
//        this.userDao = new UserDaoImpl();
//    }


    @Override
    public boolean checkUserExist(User user) {
        List<User> allUsers = userDao.findAllUsers();
        return allUsers.contains(user);
    }
}
