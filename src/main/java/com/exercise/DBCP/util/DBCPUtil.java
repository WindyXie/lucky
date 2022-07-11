package com.exercise.DBCP.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
public class DBCPUtil {
    private static Properties properties = new Properties();
    private static DataSource dataSource;
    //加载DBCP配置文件
    static{
       try{
          //注意这里需要使用绝对路径
          FileInputStream is = new FileInputStream("src/main/java/com/exercise/DBCP/xml/dbcp.properties");  
          properties.load(is);
       }catch(IOException e){
          e.printStackTrace();
       }
       //获取数据源对象
       try{
           dataSource = BasicDataSourceFactory.createDataSource(properties);
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    //从连接池中获取一个连接
    public static Connection getConnection(){
       Connection connection = null;
       try{
            connection = dataSource.getConnection();
        }catch(SQLException e){
            e.printStackTrace();
        }
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection conn = null;
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
        }
    }
}
