package com.exercise.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.exercise.mybatis.dao.A;
import com.exercise.mybatis.dao.AMapper;

import java.io.InputStream;
import java.util.List;

/**
 * 单例模式
 */
public class SqlSessionFactoryUtil {
    private SqlSessionFactoryUtil(){}
    private static SqlSessionFactory sqlSessionFactory;
    static {
        String resource= "com/exercise/mybatis/xml/mybatis-config.xml";
        try{
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
    public static void application(){
        SqlSession sqlSession = getSqlSession();
        AMapper aMapper = sqlSession.getMapper(AMapper.class);
        List<A> aList = aMapper.listName("a2");
        for (A a : aList) {
            System.out.println("the value of row1:"+a.getDif1()+" the value of row2:"+a.getDif2()+" the value of row3:"+a.getDif3());
        }
    }

    public static void main(String[] args) {
        application();
    }
}

