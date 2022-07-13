package com.exercise.ioc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.exercise.ioc.service.UserServiceImpl;

@Controller("userCon")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Value("9527")
    private int userId;

    public void getUser() {
        System.out.println(userServiceImpl.getById(userId));
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =new ClassPathXmlApplicationContext("com/exercise/ioc/xml/spring-config.xml");
        UserController userController = (UserController) applicationContext.getBean("userCon");
        userController.getUser();
        applicationContext.close();
    }
}
