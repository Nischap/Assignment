package com.uxpsystems.assignment.service;

import com.uxpsystems.assignment.dao.UserDao;
import com.uxpsystems.assignment.entity.User;
import com.uxpsystems.assignment.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.uxpsystems.assignment.constant.Constants.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public String addUser(UserDao userDao) {
        userRepository.save(daoToEntity(userDao, null));
        return String.format(addUserResponse, userDao.getUserName());
    }

    @Override
    public UserDao getUser(String userName) throws NotFoundException {
        return entityToDao(getUserByUsername(userName));
    }

    @Override
    public String updateUser(UserDao userDao) throws NotFoundException {
        userRepository.save(daoToEntity(userDao, getUserByUsername(userDao.getUserName()).getUserId()));
        return String.format(updatedUserResponse, userDao.getUserName());
    }

    @Override
    public String deleteUser(String userName) throws NotFoundException {
        userRepository.delete(getUserByUsername(userName));
        return String.format(deletedUserResponse, userName);
    }

    private User getUserByUsername(String userName) throws NotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        if (user.isEmpty()) {
            throw new NotFoundException(userNotFound);
        }
        return user.get();
    }

    private UserDao entityToDao(User user) {
        return UserDao.builder()
                .userName(user.getUserName())
                .userId(user.getUserId())
                .password(user.getPassword())
                .status(user.getStatus())
                .build();
    }

    private User daoToEntity(UserDao userDao, Long id) {
        return User.builder()
                .userId(id)
                .userName(userDao.getUserName())
                .password(userDao.getPassword())
                .status(userDao.getStatus())
                .build();
    }
}
