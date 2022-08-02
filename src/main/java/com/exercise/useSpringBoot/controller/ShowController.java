package com.exercise.useSpringBoot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.mybatis.dao.Dir;
import com.exercise.mybatis.dao.dirMapper;

@RestController
@RequestMapping(value = "/xx")
public class ShowController {
    @Autowired
    dirMapper dirMapper;

    @GetMapping("/get")
    public List<Dir> get() {
        return dirMapper.sel();
    }

    @GetMapping("/get1")
    public String get1() {
        return "1";
    }
}
