package com.travelling.Plane.service;

import com.travelling.Plane.bean.User;

import java.util.List;

public interface UserService
{
    public void addUser(User user);

    public List<User> getUsers();

    public User getUser(int userId);

    public void deleteUser(int userId);
}
