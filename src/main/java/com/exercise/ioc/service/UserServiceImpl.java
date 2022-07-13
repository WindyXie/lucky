package com.exercise.ioc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.ioc.dao.User;
import com.exercise.ioc.dao.UserDaoImpl;

@Service
public class UserServiceImpl {
    @Autowired
    private UserDaoImpl userDaoImpl;

    public User getById(int userId) {
        System.out.println("中间");
        return userDaoImpl.getById(userId);
    }
}
