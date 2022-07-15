package com.springByWritten.service;

import com.springByWritten.spring.Autowired;
import com.springByWritten.spring.Component;
import com.springByWritten.spring.Scope;

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
