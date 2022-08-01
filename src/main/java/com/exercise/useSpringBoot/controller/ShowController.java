package com.exercise.useSpringBoot.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.mybatis.dao.Dir;
import com.exercise.mybatis.dao.dirMapper;

@RestController("")
public class ShowController {
    @Resource
    dirMapper dirMapper;

    @GetMapping("")
    public List<Dir> get() {
        return dirMapper.sel();
    }
}
