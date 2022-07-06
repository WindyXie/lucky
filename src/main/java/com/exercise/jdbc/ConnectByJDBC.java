package com.exercise.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectByJDBC {
    public static void main(String... args) {
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 获取连接
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elf?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC", "root", "elf");
            if (!con.isClosed()) {
                System.out.println("succeed connect");
            }
            // 3. 创建statement对象
            Statement statement = con.createStatement();
            // 4. 执行sql语句
            ResultSet rs = statement.executeQuery("select * from a");
            // 5. 处理结果
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            // 6. 关闭
            rs.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
