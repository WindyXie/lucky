package com.exercise.c3po.util;

 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
 
 public class C3P0_Utils {
     
     private static ComboPooledDataSource dataSource = null;
     //在静态代码块中创建数据库连接池
     static{
         try{
        	 dataSource = new ComboPooledDataSource("MySQL");//使用C3P0的命名配置来创建数据源
             
         }catch (Exception e) {
             throw new ExceptionInInitializerError(e);
         }
     }
     
     public static Connection getConnection() throws SQLException{
         //从数据源中获取数据库连接
         return dataSource.getConnection();
     }
     
     // 释放资源
     public static void release(Connection conn,Statement st,ResultSet rs){
         if(rs!=null){
             try{
                 //关闭存储查询结果的ResultSet对象
                 rs.close();
             }catch (Exception e) {
                 e.printStackTrace();
             }
             rs = null;
         }
         if(st!=null){
             try{
                 //关闭负责执行SQL命令的Statement对象
                 st.close();
             }catch (Exception e) {
                 e.printStackTrace();
             }
         }
         
         if(conn!=null){
             try{
                 //将Connection连接对象还给数据库连接池
                 conn.close();
             }catch (Exception e) {
                 e.printStackTrace();
             }
         }
     }


     public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            //获取数据库连接
            conn = getConnection();
            Statement statement = conn.createStatement();
            // 4. 执行sql语句
            ResultSet resultSet = statement.executeQuery("select * from a");
            // 5. 处理结果
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
        	C3P0_Utils.release(conn, st, rs);
        }
     }
 }
