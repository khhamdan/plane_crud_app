package com.travelling.Plane.service;

import com.travelling.Plane.bean.User;
import com.travelling.Plane.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }
    @Override
    public User getUser(int userId) {
        return userDao.getUser(userId);
    }

    @Override
    public void deleteUser(int userId) {
        userDao.deleteUser(userId );
    }
}
