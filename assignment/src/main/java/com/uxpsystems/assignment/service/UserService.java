package com.uxpsystems.assignment.service;

import com.uxpsystems.assignment.dao.UserDao;
import javassist.NotFoundException;

public interface UserService {
    String addUser(UserDao userDao);

    UserDao getUser(String userName) throws NotFoundException;

    String updateUser(UserDao userDao) throws NotFoundException;

    String deleteUser(String userName) throws NotFoundException;
}
