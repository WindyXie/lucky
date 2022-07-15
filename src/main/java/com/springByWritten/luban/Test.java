package com.springByWritten.luban;

import com.springByWritten.service.OrderService;
import com.springByWritten.spring.LubanApplicationContext;

public class Test {
    public static void main(String... args) {
        // 启动spring
        LubanApplicationContext applicationContext = new LubanApplicationContext(AppConfig.class);
        // getBean()
        OrderService orderService = (OrderService)applicationContext.getBean("orderService");
        System.out.println(applicationContext.getBean("orderService"));
        System.out.println(applicationContext.getBean("orderService"));
        System.out.println(applicationContext.getBean("orderService"));

        orderService.test();
    }
}
