package com.exercise.springByWritten.service;

import com.exercise.springByWritten.spring.Autowired;
import com.exercise.springByWritten.spring.Component;
import com.exercise.springByWritten.spring.Scope;

@Component("orderService")
// @Scope("prototype")
@SuppressWarnings("all")
public class OrderService {
    @Autowired
    private UserService userService;

    public void test() {
        System.out.print(userService);
    }
}
