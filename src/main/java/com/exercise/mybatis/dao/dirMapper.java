package com.exercise.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface dirMapper{
    List<Dir> selectDirTree2(Long id);
    List<Dir> sel();
}
